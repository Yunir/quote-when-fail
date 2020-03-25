package com.yunir

import org.gradle.api.Plugin
import org.gradle.api.Project

class QPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.gradle.buildFinished() {
            if (it.failure != null) println("\"To be, or not to be: that is the question\" (c) William Shakespeare")
        }
        project.task("qoute") {
            it.group = "lucky"
            it.doLast {
                println("To be, or not to be: that is the question\" (c) William Shakespeare")
            }
        }
    }

}