java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}