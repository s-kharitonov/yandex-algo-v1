pluginManagement {
    val springDependencyManagementVersion: String by settings

    plugins {
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

rootProject.name = "yandex-algo-v1"

include("hw1")