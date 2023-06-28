plugins {
   alias(libs.plugins.kotlin)
   alias(libs.plugins.kotlin.serialization)
}

group = "space.mrtuxa.link"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.5")
    testImplementation(kotlin("test"))
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
    implementation("dev.kord:kord-core:0.10.0-SNAPSHOT")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.8-SNAPSHOT")

}

kotlin {
    jvmToolchain(19)
}

/**
 * schlaubi sagt braucht man nicht
tasks.test {
    useJUnitPlatform()
}
*/

/**
 * schlaubi sagt braucht man nicht
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
 */