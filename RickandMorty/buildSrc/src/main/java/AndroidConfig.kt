object AndroidConfig {

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    const val applicationId = "com.example.rickandmorty"

    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildTools = "30.0.0"

    const val versionCode = versionMajor * 100 + versionMinor * 10 + versionPatch
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"

    const val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

}
