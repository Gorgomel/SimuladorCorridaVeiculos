plugins {
    application
    id("com.diffplug.spotless") version "6.25.0"
    jacoco
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Log
    implementation("org.slf4j:slf4j-api:2.0.16")
    runtimeOnly("ch.qos.logback:logback-classic:1.5.8")

    // Testes (JUnit 5)
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    // Main de console
    mainClass.set("poo.trabalho.fun.UsaSimulador")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

spotless {
    java {
        googleJavaFormat()
        target("src/main/java/**/*.java", "src/test/java/**/*.java")
        // TEMP: excluir legado enquanto normalizamos
        targetExclude("src/main/java/poo/**")
    }
}

jacoco {
    toolVersion = "0.8.12"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

// Make `gradlew check` run format check + tests + coverage report
tasks.check {
    dependsOn("spotlessCheck", "test", "jacocoTestReport")
}

// Permite entrada pelo teclado no `gradlew run`
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
