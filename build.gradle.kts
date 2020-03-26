plugins {
    kotlin("jvm") version "1.3.70"
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.10.1"
    java
    maven
}

group = "com.yunir"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("org.jsoup:jsoup:1.13.1")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    getByName<Upload>("uploadArchives") {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenDeployer {
                    withGroovyBuilder {
                        "repository"("url" to uri(mavenLocal().url))
                    }
                }
            }
        }
    }
}

pluginBundle {
    website = "https://github.com/yunir/quote-when-fail"
    vcsUrl = "https://github.com/yunir/quote-when-fail"
    tags = listOf("quote", "fail", "postbuild")
}

gradlePlugin {
    plugins {
        create("quote-when-fail") {
            id = "com.yunir.quote-when-fail"
            displayName = "quote-when-fail"
            description = "used to print motivational or funny quote, when build fails"
            implementationClass = "com.yunir.QPlugin"
        }
    }
}

