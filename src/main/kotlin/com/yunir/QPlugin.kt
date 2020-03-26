package com.yunir

import org.gradle.api.Plugin
import org.gradle.api.Project

class QPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.gradle.buildFinished() {
            if (it.failure != null) {
                val qg = QuoteGrabber()
                qg.grabNewQuote()
            }
        }
        project.task("qoute") {
            it.group = "lucky"
            it.description = "task to check manually that quotes retrieves correctly"
            it.doLast {
                val qg = QuoteGrabber()
                qg.grabNewQuote()
            }
        }
    }
}