# Google Mobile Ads SDK
-keep class com.google.android.gms.ads.** { *; }
-dontwarn com.google.android.gms.ads.**

# Room Database
-keep class androidx.room.** { *; }
-dontwarn androidx.room.**

# Retrofit & Moshi
-keepattributes *Annotation*, Signature, InnerClasses, EnclosingMethod
-keepclassmembers class * {
    @com.squareup.moshi.* <fields>;
    @com.squareup.moshi.* <methods>;
}

# Preserve Line Numbers for Crash Reporting
-keepattributes SourceFile,LineNumberTable
