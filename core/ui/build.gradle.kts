plugins {
    id("gitcollection.android.library")
    id("gitcollection.android.compose")
}

android {
    namespace = "com.google.samples.apps.nowinandroid.core.ui"
    compileSdk = 33
    defaultConfig {
        targetSdk = 33
    }
}

dependencies {
    implementation(libs.androidx.compose.material3)
}