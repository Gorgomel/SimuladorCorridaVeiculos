plugins {
    application
    id("com.diffplug.spotless") version "6.25.0"
    jacoco
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

repositories { mavenCentral() }

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.16")
    runtimeOnly("ch.qos.logback:logback-classic:1.5.8")

    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("app.simulator.App")
}

tasks.test { useJUnitPlatform() }

spotless {
    java {
        googleJavaFormat()
        target("src/**/*.java")
    }
}

jacoco { toolVersion = "0.8.12" }
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports { xml.required.set(true); html.required.set(true) }
}
