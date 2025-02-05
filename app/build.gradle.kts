plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "com.virap.musicplayer"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.virap.musicplayer"
		minSdk = 24
		this.targetSdk = 33
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	packagingOptions {
		resources.excludes.add("META-INF/*")
	}
	// for viewBinding
	buildFeatures {
		viewBinding = true
		buildConfig = true
	}
}

dependencies {

	implementation("androidx.core:core-ktx:1.12.0")
	implementation("androidx.appcompat:appcompat:1.7.0-alpha03")
	implementation("com.google.android.material:material:1.11.0")
	implementation("androidx.constraintlayout:constraintlayout:2.1.4")
	//// Glide for image loading
	implementation("com.github.bumptech.glide:glide:5.0.0-rc01")
	//// For notification
	implementation("androidx.media:media:1.7.0")
	//// For storing objects in shared preferences
	implementation("com.google.code.gson:gson:2.10.1")
	//// For sending mail
	implementation("com.sun.mail:android-mail:1.6.7")
	implementation("com.sun.mail:android-activation:1.6.7")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}