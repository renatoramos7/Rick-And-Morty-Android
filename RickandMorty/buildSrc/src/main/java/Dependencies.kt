object Dependencies {

    /** Gradle **/
    const val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"

    /** Android X **/
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompatibVersion}"
    const val androidx_constraintlayout =  "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintlayoutLibVersion}"
    const val androidx_recyclerview =  "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerviewLibVersion}"

    const val androidx_lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidx_lifecycleLibVersion}"
    const val androidx_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_lifecycleLibVersion}"
    const val androidx_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidx_lifecycleLibVersion}"

    const val androidx_lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidx_lifecycleLibVersion}"
    const val androidx_paging =  "androidx.paging:paging-runtime:${Versions.androidx_pagingLibVersion}"
    const val androidx_paging_rxjava2 = "androidx.paging:paging-rxjava2:${Versions.androidx_pagingLibVersion}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidx_navigationLibVersion}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.androidx_navigationLibVersion}"
    const val navigation_dynamic_features = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.androidx_navigationLibVersion}"

    /** Kotlin KTX **/
    const val kotlinKTX = "androidx.core:core-ktx:${Versions.kotlinKTXLibVersion}"

    /** Google-services **/
    const val google_service_plugin = "com.google.gms:google-services:${Versions.google_service}"

    /** fabric **/
    const val fabric_plugin = "io.fabric.tools:gradle:${Versions.fabric}"

    /** firebase **/
    const val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase_core}"
    const val firebase_messaging = "com.google.firebase:firebase-messaging:${Versions.firebase_messaging}"
    const val firebase_auth = "com.google.firebase:firebase-auth:${Versions.firebase_auth}"
    const val firebase_inapp_messaging_display = "com.google.firebase:firebase-inappmessaging-display:${Versions.firebase_inapp_messaging_display}"

    /** multidex **/
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    /** android_maps_utils **/
    const val android_maps_utils = "com.google.maps.android:android-maps-utils:${Versions.android_maps_utils}"

    /** io_branch_android **/
    const val io_branch_android = "io.branch.sdk.android:library:${Versions.io_branch_android}"

    /** play_services **/
    const val play_services_analytics = "com.google.android.gms:play-services-analytics:${Versions.playServices_analytics}"
    const val play_services_auth = "com.google.android.gms:play-services-auth:${Versions.playServices_auth}"
    const val play_services_places = "com.google.android.gms:play-services-places:${Versions.playServices_places}"
    const val play_services_location = "com.google.android.gms:play-services-location:${Versions.playServices_location}"
    const val play_services_maps = "com.google.android.gms:play-services-maps:${Versions.playServices_maps}"
    const val play_services_ads = "com.google.android.gms:play-services-ads:${Versions.playServices_ads}"
    const val play_services_gcm = "com.google.android.gms:play-services-gcm:${Versions.playServices_gcm}"
    const val play_services_base = "com.google.android.gms:play-services-base:${Versions.playServices_base}"

    /** Kotlin **/
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_stdlib_jre7 = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    const val kotlin_stdlib_jre8 = "org.jetbrains.kotlin:kotlin-stdlib-jre8:${Versions.kotlin}"
    const val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    /** Anko Kotlin **/
    const val anko = "org.jetbrains.anko:anko:${Versions.anko}"

    /** Android Support Dependencies **/
    const val support_appcompat_V7 = "com.android.support:appcompat-v7:${Versions.supportLibVersion}"
    const val support_support_V4 = "com.android.support:support-v4:${Versions.supportLibVersion}"
    const val support_design = "com.android.support:design:${Versions.supportLibVersion}"
    const val support_cardview_V7 = "com.android.support:cardview-v7:${Versions.supportLibVersion}"
    const val support_recyclerview_V7 = "com.android.support:recyclerview-v7:${Versions.supportLibVersion}"
    const val support_constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutLibVersion}"
    const val support_gridlayout_v7 = "com.android.support:gridlayout-v7:${Versions.supportLibVersion}"
    const val support_media_compat =  "com.android.support:support-media-compat:${Versions.supportLibVersion}"
    const val support_customtabs =  "com.android.support:customtabs:${Versions.supportLibVersion}"
    const val support_exifinterface =  "com.android.support:exifinterface:${Versions.supportLibVersion}"

    /** Android Data Binding **/
    const val dataBinding = "com.android.databinding:compiler:${Versions.dataBindingLibVersion}"

    /** Architecture components **/
    /** ViewModel and LiveData components **/
    const val arch_lifecycle = "android.arch.lifecycle:extensions:${Versions.archComponentLibVersion}"
    const val arch_lifecycle_compiler = "android.arch.lifecycle:compiler:${Versions.archComponentLibVersion}"
    const val arch_lifecycle_common_java8 = "android.arch.lifecycle:common-java8:${Versions.archComponentLibVersion}"
    const val archRxJavaSupport   = "android.arch.lifecycle:reactivestreams:${Versions.archComponentLibVersion}"

    /** Room components **/
    const val arch_room = "android.arch.persistence.room:runtime:${Versions.roomLibVersion}"
    const val arch_room_compiler = "android.arch.persistence.room:compiler:${Versions.roomLibVersion}"

    // optional - RxJava support for Room
    const val arch_room_rxjava2 = "android.arch.persistence.room:rxjava2:${Versions.roomLibVersion}"

    /** Paging **/
    const val arch_paging = "android.arch.paging:runtime:${Versions.padingLibVersion}"

    /** Dagger Dependencies **/
    const val dagger = "com.google.dagger:dagger:${Versions.daggerLibVersion}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.daggerLibVersion}"
    const val dagger_processor = "com.google.dagger:dagger-android-processor:${Versions.daggerLibVersion}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.daggerLibVersion}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.daggerLibVersion}"

    /** ReactiveX Dependencies **/
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2LibVersion}"
    const val rxandroid2 = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid2LibVersion}"

    const val rxjava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxjava3LibVersion}"
    const val rxandroid3 = "io.reactivex.rxjava3:rxandroid:${Versions.rxjava3LibVersion}"

    /** RetroFit **/
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2LibVersion}"

    /** RetroFit converter **/
    // Gson
    const val retrofit2_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2LibVersion}"

    // Moshi
    const val retrofit2_converter_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.converterMoshiLibVersion}"

    /** RetroFit adapter **/
    const val retrofit2_adapter_rxjava2 =  "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxjavaAdapterLibVersion}"

    /** Gson **/
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    /** Moshi **/
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiLibVersion}"
    const val moshi_adapters =  "com.squareup.moshi:moshi-adapters:${Versions.moshiLibVersion}"
    const val moshi_kotlin =  "com.squareup.moshi:moshi-kotlin:${Versions.moshiLibVersion}"

    /** OkHttp **/
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3LibVersion}"
    const val okhttp_logging_interceptor =  "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3LibVersion}"

    /** Log **/
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    /** Memory leak detection **/
    const val memoryLeakDebug = "com.squareup.leakcanary:leakcanary-android:${Versions.memoryLeak}"
    const val memoryLeakRelease = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.memoryLeak}"

    /** Image cache **/
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideLibVersion}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glideLibVersion}"
    const val glide_okhttp3= "com.github.bumptech.glide:okhttp3-integration:${Versions.glideLibVersion}"

    /**  Image Zoom **/
    const val imagezoom =  "it.sephiroth.android.library.imagezoom:imagezoom:${Versions.imageZoomLibVersion}"

    /**  Image easyImage **/
    const val easyImage =  "com.github.jkwiecien:EasyImage:${Versions.easyImage}"

    /** paperdb **/
    const val paperdb = "io.paperdb:paperdb:${Versions.paperdbLibVersion}"

    /**************** Test Dependencies *********************/

    /** Mockito  **/
    const val mockito = "org.mockito:mockito-core:${Versions.mockitoLibVersion}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockitoLibVersion}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockitoLibVersion}"

    /** Mockito  Kotlin **/
    const val mockito_Kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinLibVersion}"

    /** okhttp mock Web Server **/
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

    /** JUnit **/
    const val junit = "junit:junit:${Versions.junitLibVersion}"

    /** Architecture components **/
    const val arch_core_testing = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
    const val arch_room_testing = "android.arch.persistence.room:testing:${Versions.roomLibVersion}"

    /**  Kotlin Test Support **/
    const val kotlin_test =  "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val kotlin_test_junit =  "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

    /**  Espresso **/
    const val support_test_runner = "com.android.support.test:runner:${Versions.supportTestRunner}"
    const val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espressoCoreLibVersion}"

    const val androidx_test = "androidx.test:runner:${Versions.androidx_TestRunnerLibVersion}"
    const val androidx_test_espresso =  "androidx.test.espresso:espresso-core:${Versions.androidx_espressoLibVersion}"
}