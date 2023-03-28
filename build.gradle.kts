plugins {
    java
    war
    id("org.springframework.boot") version "2.7.10"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("io.freefair.lombok") version "8.0.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

val templateEngine: String? by project

var useJsp = templateEngine?.let {
    it.toLowerCase() == "jsp";
} ?: false

val useThymeleaf = useJsp.not()

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    // spring-boot-starter-tomcat is included by default
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    if (useJsp) {
        providedRuntime("javax.servlet:jstl:1.2")
    }
    if (useThymeleaf) {
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
