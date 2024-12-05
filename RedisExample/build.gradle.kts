plugins {
    id("java")
}

group = "com.redis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("redis.clients:jedis:4.6.3")
}

tasks.test {
    useJUnitPlatform()
}