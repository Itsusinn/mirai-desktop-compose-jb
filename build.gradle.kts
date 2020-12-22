import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
   kotlin("jvm") version "1.4.21"
   id("org.jetbrains.compose") version "0.3.0-build135"
}

group = "io.gi.it"
version = "1.0"

val vertxVersion = "3.8.0"

repositories {
   jcenter()
   mavenCentral()
   maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
   //vertx
   implementation("io.vertx:vertx-core:$vertxVersion")
   implementation("io.vertx:vertx-web:$vertxVersion")
   implementation("io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion")
   implementation("io.vertx:vertx-lang-kotlin:$vertxVersion")

   implementation("net.mamoe:mirai-core:1.3.3")
   implementation("net.mamoe:mirai-core-qqandroid:1.3.3")
   implementation(compose.desktop.currentOs)
   implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

tasks.withType<KotlinCompile> {
   kotlinOptions.jvmTarget = "11"
}

compose.desktop {
   application {
      mainClass = "io.gi.it.mirai.desktop.MainKt"
      nativeDistributions {
         targetFormats(
            TargetFormat.Dmg,
            TargetFormat.Exe,
            TargetFormat.Deb,
            TargetFormat.AppImage
         )
         packageName = "mirai-desktop"
      }
   }
}