plugins {
    java
    `java-library`
    `maven-publish`
}

val minestomVersion = "d411c271cf"
val cloudVersion = "1.8.3"

group = "me.konicai"
//Use the same version as cloud
version = cloudVersion

tasks.withType<JavaCompile> {
    options.release.set(17)
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    //maven("https://libraries.minecraft.net")
    //maven("https://repo.spongepowered.org/maven")
}

dependencies {
    api("cloud.commandframework:cloud-core:$cloudVersion")
    compileOnly("com.github.hollow-cube:minestom-ce:$minestomVersion")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
