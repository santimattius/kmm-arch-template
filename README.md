<p align="center">
<img height="200" src="https://github.com/santimattius/kmm-arch-template/blob/master/screenshot/kmm-header.png?raw=true" alt="Android Home Screen"/>
</p>

# KMM Arch Template

This is a template to build an Android/iOS application applying good practices and using a clean architecture, 
using Kotlin Mobile Multiplatform, which will allow you to share the definition of your domain (the context of your application/business).

Oficial documentation: https://kotlinlang.org/lp/mobile/

## Screenshots

<p align="center">
  <img height="600" src="https://github.com/santimattius/kmm-arch-template/blob/master/screenshot/kmm-android-app.png?raw=true" alt="Android Home Screen"/>
  <img height="600" src="https://github.com/santimattius/kmm-arch-template/blob/master/screenshot/kmm-ios-app.png?raw=true" alt="Android Detail Screen"/>
</p>

## Application architecture

In the following images you will see how the app is built and what its levels of abstraction are.

### General

<p align="left">
  <img height="600" src="https://github.com/santimattius/kmm-arch-template/blob/master/screenshot/kmm-components.png?raw=true" alt="general architecture"/>
</p>

### Project structure

<p align="left">
  <img width="700" src="https://github.com/santimattius/kmm-arch-template/blob/master/screenshot/basic-project-structure.png?raw=true" alt="Project packages"/>
</p>

## Dependencies

Below you will find the libraries used to build the template and according to my criteria the most used in android development so far.

### Shared
- [Ktor for networking](https://kotlinlang.org/docs/mobile/use-ktor-for-networking.html)  
- [Kotlin serialization](https://kotlinlang.org/docs/serialization.html)
- [Koin](https://insert-koin.io/)
- [Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
- [SQLDelight](https://github.com/cashapp/sqldelight)
 
### Android
-  [Jetpack compose](https://developer.android.com/jetpack/compose)
-  [Paging 3.0](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
-  [Jetpack compose navigation](https://developer.android.com/jetpack/compose/navigation?hl=es-419)
-  [Koin](https://insert-koin.io/)
-  [Coil](https://coil-kt.github.io/coil/compose/)
-  [Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Kotlion Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)

### iOS
- [SwiftUI](https://developer.apple.com/xcode/swiftui/)
- [AsyncImage](https://developer.apple.com/documentation/swiftui/asyncimage)
- [Combine](https://developer.apple.com/documentation/combine)

## Referencias

- [Kotlin Mobile Multiplaform Official site](https://kotlinlang.org/lp/mobile/)
