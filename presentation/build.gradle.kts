plugins {
    id(Config.Plugins.application)
    id(Config.Plugins.kotlin)
    id(Config.Plugins.hilt)
    id(Config.Plugins.kapt)
}

android {
    compileSdk = Config.Version.compileSdk
    buildToolsVersion = Config.Version.buildToolVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.Version.minSdk
        targetSdk = Config.Version.targetSdk
        versionCode = Config.Version.versionCode
        versionName =Config.Version.versionName
        testInstrumentationRunner = Config.Android.Test.jUnitRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(Config.Modules.data))
    implementation(project(Config.Modules.domain))

    implementation(Config.Android.Hilt.hiltAndroid)
    kapt(Config.Android.Hilt.hiltAndroidCompiler)
    kapt(Config.Android.Hilt.hiltCompiler)
    implementation(Config.Android.Hilt.hiltLifecycleViewModel)

    implementation(Config.Kotlin.Coroutine.coroutines)
    testImplementation(Config.Kotlin.Coroutine.coroutineTest)

    implementation(Config.Google.playServiceAuth)
    implementation(Config.Google.playServiceLocation)
    implementation(Config.Google.gson)

    implementation(Config.Square.otto)
    implementation(Config.Square.retrofit)
    implementation(Config.Square.retrofitGsonConverter)
    implementation(Config.Square.retrofitRxJava3Adapter)
    implementation(Config.Square.okhttp)
    implementation(Config.Square.okhttpLogging)

    implementation(Config.Android.KTX.activity)
    implementation(Config.Android.KTX.fragment)
    implementation(Config.Android.recyclerView)

    implementation(Config.Glide.glide)
    implementation(Config.Glide.glideCompiler)

    implementation(Config.Android.Splash.splashScreen)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}