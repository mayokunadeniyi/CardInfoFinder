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
    val coroutines = "1.3.7"
    val retrofit = "2.9.0"
    val timber = "4.7.1"

    val lifecycle_version = "2.2.0"
    val nav_version = "2.3.0"
    val material_version = "1.3.0-alpha01"
    val lifecycle_ext = "2.1.1"
    val room_version = "2.2.5"
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
    val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"

    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    val material_design = "com.google.android.material:material:${Versions.material_version}"
    val lifecycle_extensions = "android.arch.lifecycle:extensions:${Versions.lifecycle_ext}"
    val room = "androidx.room:room-runtime:${Versions.room_version}"
    val room_ktx = "androidx.room:room-ktx:${Versions.room_version}"
    val room_compiler = "androidx.room:room-compiler:${Versions.room_version}"
    val nav_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"




}