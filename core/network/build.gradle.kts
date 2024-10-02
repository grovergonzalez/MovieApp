plugins {
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ucb.android.library)
    alias(libs.plugins.kapt)
}


android {
    namespace = "com.Compose3.network"
}

dependencies{
    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.converter.moshi)
    kapt(libs.moshi.kapt)
}

kapt{
    correctErrorTypes = true
}