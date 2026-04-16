import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"
object MyVcsRoot : GitVcsRoot({
    name = "Anton-Shcherbatykh"
    url = "https://github.com/Anton-Shcherbatykh/FOPS38-18_example-teamcity.git"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "Anton-Shcherbatykh"
        password = "credentialsJSON:ваш_токен_id"
    }
})

project {
    description = "Домашнее задание к занятию 11 «Teamcity»"

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            name = "mvn clean deploy"
            id = "Maven2"
            goals = "clean deploy"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            userSettingsSelection = "settings.xml"
        }
        maven {
            name = "mvn clean test"
            id = "mvn_clean_test"

            conditions {
                doesNotContain("teamcity.build.branch", "master")
            }
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            userSettingsSelection = "settings.xml"
        }
    }

    features {
        perfmon {
        }
    }
   triggers {
       vcs {
            branchFilter = "+:*"  // Запускать для всех веток
        }
    }
})
