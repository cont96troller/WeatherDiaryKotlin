import java.util.Properties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

val localProperties = loadProperties(project.rootProject.file("local.properties"))

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val apiKey = localProperties.getProperty("weather.api.key", "")
        buildConfigField("String", "WEATHER_API_KEY", apiKey)
    }

    buildTypes {
        debug {}
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // hilt
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    // coroutines
    implementation(libs.kotlinx.coroutines.core)

    // okHttp
    implementation(platform(libs.okhttp.bom))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // retrofit
    implementation(libs.converter.gson)
    implementation(libs.retrofit)

    // gson
    implementation(libs.gson)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)


}

fun loadProperties(file: File?) = Properties().apply {
    if (file != null && file.exists()) {
        file.inputStream().use { fis ->
            load(fis)
        }
    }
}