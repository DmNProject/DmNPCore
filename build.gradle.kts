import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("maven-publish")
    kotlin("multiplatform") version "1.5.10"
}

group = "ru.DmN.Project"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    js(LEGACY) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("commons-io:commons-io:2.4")

                // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
                implementation ("org.apache.commons:commons-lang3:3.0")
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group as String?
            artifactId = "core"
            version = project.version as String?

            pom {
                name.set("DmNProject")
                description.set("DmNProject")
                url.set("https://github.com/DmNProject/DmNPCore")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://github.com/DmNProject/DmNPCore/blob/master/LICENSE")
                    }
                }

                developers {
                    developer {
                        id.set("Domaman202")
                        name.set("Pavel 4auka")
                        email.set("vip.domaman@mail.ru")
                    }
                }

                scm {
                    connection.set("scm:git:git://DmNProject/DmNPCore")
                    developerConnection.set("scm:git:ssh://DmNProject/DmNPCore")
                    url.set("https://github.com/DmNProject/DmNPCore")
                }
            }
        }
    }
    repositories {
        maven {
            url = uri("https://repo.levkopo.ru/repository/maven/")
            credentials {
                try {
                    val properties = Properties()
                    properties.load(project.rootProject.file("local.properties").inputStream())
                    username = properties["levkopoRepoUsername"] as String?
                    password = properties["levkopoRepoPassword"] as String?
                } catch (ignored: Throwable) { }
            }
        }
    }
}