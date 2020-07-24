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
    val edit_text_anim = "2.0.2"
    val koin_version = "2.1.5"
    val retrofit_adapter = "0.9.2"
    val okhttp_logger = "4.7.2"
    val legacy_support = "1.0.0"
    val elastic_view = "2.0.7"
    val image_cropper = "2.8.0"
    val firebase_ml = "24.0.3"
    val google_services = "4.3.3"
    val glide_version = "4.11.0"
    val mockito_version = "2.27.0"
}

object Deps {
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val android_build_tools = "com.android.tools.build:gradle:${Versions.android_build_tools}"
    val androidx_core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val androidx_legacy_support = "androidx.legacy:legacy-support-v4:${Versions.legacy_support}"
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
    val koin_android = "org.koin:koin-android:${Versions.koin_version}"
    val koin_androidx_scope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
    val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
    val retrofit_coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_adapter}"
    val okhttp_logger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logger}"
    val elastic_view = "com.github.skydoves:elasticviews:${Versions.elastic_view}"
    val edit_text_anim = "com.alimuzaffar.lib:animated-edit-text:${Versions.edit_text_anim}"
    val firebase_ml_vision = "com.google.firebase:firebase-ml-vision:${Versions.firebase_ml}"
    val google_services = "com.google.gms:google-services:${Versions.google_services}"
    val cropper = "com.theartofdev.edmodo:android-image-cropper:${Versions.image_cropper}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito_version}"
    val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"





}