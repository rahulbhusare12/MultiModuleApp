import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val core_ktx="androidx.core:core-ktx:${Versions.core_ktx}"
    const val lifecycle_runtime_ktx="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime_ktx}"
    const val activity_compose="androidx.activity:activity-compose:${Versions.activity_compose}"
    const val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom}"
    const val  voyagerNavigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyagerVersion}"
    const val  voyagerTransitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyagerVersion}"
    const val  voyagerHilt = "cafe.adriel.voyager:voyager-hilt:${Versions.voyagerVersion}"
    const val  voyagerKoin = "cafe.adriel.voyager:voyager-koin:${Versions.voyagerVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val koinBom = "io.insert-koin:koin-bom:${Versions.koinBom}"
    const val koin = "io.insert-koin:koin-android:${Versions.koinBom}"
    const val koinCore = "io.insert-koin:koin-core"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
}

fun DependencyHandler.coreKtx(){
    implementation(Dependencies.core_ktx)
}

fun DependencyHandler.lifeCycleRuntime(){
    implementation(Dependencies.lifecycle_runtime_ktx)
}
fun DependencyHandler.activityCompose(){
    implementation(Dependencies.activity_compose)
}

fun DependencyHandler.voyagerNavigator(){
    implementation(Dependencies.voyagerNavigator)
    implementation(Dependencies.voyagerTransitions)
    implementation(Dependencies.voyagerHilt)

}
fun DependencyHandler.composeBom(){
    implementation(platform(Dependencies.compose_bom))
}fun DependencyHandler.koinBom(){
    //implementation(platform(Dependencies.koinBom))
  //  implementation(Dependencies.koinCore)
    implementation(Dependencies.koin)
}
fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConvertor)
    implementation(Dependencies.okHttp)
}


fun DependencyHandler.categoryUI() {
    implementation(project(":feature:category:ui"))
}
fun DependencyHandler.categoryData() {
    implementation(project(":feature:category:data"))
}fun DependencyHandler.categoryDomain() {
    implementation(project(":feature:category:domain"))
}


fun DependencyHandler.categoryDetailsUI() {
    implementation(project(":feature:categoryDetails:ui"))
}
fun DependencyHandler.coreCommon() {
    implementation(project(":core:common"))
}
fun DependencyHandler.coreNetwork() {
    implementation(project(":core:network"))
}
