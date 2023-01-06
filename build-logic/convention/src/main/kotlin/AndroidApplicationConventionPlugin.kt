import com.android.build.api.dsl.ApplicationExtension
import com.diegocarloslima.gitcollection.buildlogic.AndroidConfig
import com.diegocarloslima.gitcollection.buildlogic.configureBaseKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureBaseKotlinAndroid(this)

                defaultConfig {
                    targetSdk = AndroidConfig.TARGET_SDK
                }

                packagingOptions {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
            }
        }
    }
}