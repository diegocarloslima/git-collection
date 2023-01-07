plugins {
    id("gitcollection.android.library")
    id("gitcollection.android.compose")
}

android {
    namespace = "com.google.samples.apps.nowinandroid.core.ui"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.androidx.compose.material3)
}