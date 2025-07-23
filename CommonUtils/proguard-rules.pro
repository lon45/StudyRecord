# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# 保留对外暴露的类和方法
-keep public class com.nader.commonutils.test.** {
    public *;
}

# 如果使用了 Kotlin
-keep class com.nader.commonutils.test.** { *; }

# 保留注解
-keepattributes Signature,RuntimeVisibleAnnotations,AnnotationDefault

# 如果使用了反射
-keepclassmembers class com.nader.commonutils.** {
    <fields>;
    <methods>;
}

