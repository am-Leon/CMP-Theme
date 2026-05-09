plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.mavenPublish)
}

group = "am.leon"
version = "1.0.0"

kotlin {
    // Explicitly enable sources JAR for all targets (required by Maven Central)
    withSourcesJar(true)

    android {
        namespace = "$group.theme"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        minSdk = 26
    }

    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "themeKit"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.compose.material3)
                implementation(libs.kotlin.stdlib)
            }
        }
    }
}

mavenPublishing {
    // Publish to Maven Central Portal
    publishToMavenCentral()

    // Only sign if we are NOT publishing to mavenLocal
    if (!project.gradle.startParameter.taskNames.any { it.contains("Local", ignoreCase = true) }) {
        // GPG sign all publications (required for Maven Central)
        signAllPublications()
    }

    // Coordinates
    coordinates(
        groupId = "io.github.am-leon",
        artifactId = "cmp-theme",
        version = version.toString()
    )

    // POM metadata
    pom {
        name.set("Leon Compose Theme")
        description.set("Generic Compose Multiplatform theme system with centralized token architecture.")
        inceptionYear.set("2026")
        url.set("https://github.com/am-Leon/CMP-Theme")

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("am-Leon")
                name.set("Abduelrahman Elemam")
                email.set("abduelrahman.elemam@gmail.com")
                organization.set("am-Leon")
                organizationUrl.set("https://github.com/am-Leon")
            }
        }

        scm {
            url = "https://github.com/am-Leon/CMP-Theme"
            connection = "scm:git:git://github.com/am-Leon/CMP-Theme.git"
            developerConnection = "scm:git:ssh://git@github.com/am-Leon/CMP-Theme.git"
        }
    }
}