plugins {
    `kotlin-dsl`
}

group = "com.diegocarloslima.gitcollection.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "gitcollection.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}
