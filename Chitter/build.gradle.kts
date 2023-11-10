buildscript {
    repositories {
        google() // Make sure this is included
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.3") // Ensure you're using the correct version
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31") // Use the version compatible with your Kotlin plugin
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5") // Use the version compatible with your Navigation plugin
        // NOTE: The Safe Args classpath should not be added here, it's applied in the module build.gradle
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}