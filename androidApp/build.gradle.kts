plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.santimattius.template.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha02"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    val kotlinVersion: String by project
    val coreKtxVersion = "1.6.0"
    val appcompatVersion = "1.3.1"
    val materialVersion = "1.4.0"
    val activityComposeVersion = "1.3.1"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation ("androidx.core:core-ktx:$coreKtxVersion")
    implementation ("androidx.appcompat:appcompat:$appcompatVersion")
    implementation ("com.google.android.material:material:$materialVersion")

    // Compose
    val composeVersion = "1.2.0-alpha02"
    implementation ("androidx.compose.ui:ui:$composeVersion")
    implementation ("androidx.compose.material:material:$composeVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation ("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation ("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation ("androidx.activity:activity-compose:$activityComposeVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeVersion")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeVersion")

    // ViewModel and LiveData
    val lifecycleVersion = "2.4.0"
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    val koinVersion = "3.1.3"
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation ("io.insert-koin:koin-androidx-compose:$koinVersion")

    //Coil Compose
    val coilComposeVersion = "1.3.2"
    implementation ("io.coil-kt:coil-compose:$coilComposeVersion")

    implementation(project(":shared"))
}