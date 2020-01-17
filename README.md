# Kotlin Multiplatform Project Example

このレポジトリは、「[みんなのKotlin](https://amzn.to/2RonLCL)」第4章 実践Kotlin開発最新情報の
「実践Kotlin Multiplatform Project開発」に掲載されているサンプルコードです。  

執筆時時点のTagが切ってありますので、執筆時と同じ環境で動作させる場合は適宜チェックアウトして下さい。  

https://github.com/AAkira/mpp-example/releases/tag/KotlinForEveryone

動作方法は書籍に記載しておりますが、わからない点がありましたら
お気軽に contact@aakira.app または、Twitter[@_a_akira](https://twitter.com/_a_akira)までお問い合わせ下さい。  

---

This project is a minimum mpp project.  

This application has Android, iOS, Web and Server modules.  
The server returns a simple JSON object and clients show it on each view.

## Android

It works on Android Studio.

![preview-android][preview-android]

## iOS

It works on XCode.

![preview-ios][preview-ios]

## Web

It works on Web browsers.

![preview-web][preview-web]

* Build command

`./gradlew :web:browserWebpack`

* Open this file on your browser after building.

`/web/src/main/resources/index.html`

## Server

It works on localhost:8080.

![preview-server][preview-server]

* Run

`./gradlew :server:run`

[preview-android]: /arts/mpp-android.jpg
[preview-ios]: /arts/mpp-ios.jpg
[preview-web]: /arts/mpp-web.jpg
[preview-server]: /arts/mpp-server.jpg
