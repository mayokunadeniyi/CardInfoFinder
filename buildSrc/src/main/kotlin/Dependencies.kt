/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

object Versions {
    val kotlin = "1.3.72"
    val compile_sdk = 30
    val target_sdk = 30
    val min_sdk_version = 21
    val build_tools_version = "30.0.0"
    val android_build_tools = "4.0.1"
    val version_code = 1
    val version_name = "1.0"
    val core_ktx = "1.3.0"

    val constraint_layout = "1.1.3"
    val androidx_app_compact = "1.1.0"
    val junit = "4.12"
    val junit_ext = "1.1.1"
    val espresso_core = "3.2.0"
}

object Deps {
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val android_build_tools = "com.android.tools.build:gradle:${Versions.android_build_tools}"
    val androidx_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val androidx_app_compact = "androidx.appcompat:appcompat:${Versions.androidx_app_compact}"
    val junit = "junit:junit:${Versions.junit}"
    val junit_ext = "androidx.test.ext:junit:${Versions.junit_ext}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}