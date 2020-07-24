# CardInfoFinder :mag::credit_card:

![Android Build](https://github.com/mayokunthefirst/CardInfoFinder/workflows/Android%20Build/badge.svg)

CardInfoFinder is an Android application that accepts input from a user specifically the Issuer Identification Numbers [IIN](https://en.wikipedia.org/wiki/Payment_card_number#Issuer_identification_number_.28IIN.29), 
previously known as Bank Identification Number (BIN), which is the first 6 or 8 digits of a payment card number (credit cards, debit cards, etc.). 
This application helps to identify the institution that issued the card to the card holder.
This application allows the user to provide the number either by entering a card number using the Soft Input keyboard or by Scanning the payment card number using the on-device OCR functionality. Once a card is scanned or the user finishes entering the card details, the app shows the following **Card brand, Card type, Bank, and Country** details of the card.
This application makes use of the [binlist API](https://binlist.net/).

## Project Characteristics

This project makes use of the following tools and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (Clean Architecture, Model-View-ViewModel)
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture ( using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage Fragment operations.)
* CI pipeline ([GitHub Actions](https://github.com/features/actions))
* Testing (Unit, UI)
* Dependency Injection
* Material design

## Tech Stack
Min API level is set to 21, so the presented approach is suitable for over 94.1% of devices running Android as at the time of writing this. 

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Koin](https://insert-koin.io/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        * [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - declaratively bind UI components in layouts to data sources.
        * [Room](https://developer.android.com/topic/libraries/architecture/room) persistence library which provides an abstraction layer over SQLite
    * [Glide](https://bumptech.github.io/glide/l) - image loading library
    * [Firebase ML Kit](https://developers.google.com/ml-kit) uses the On-Device API to recognize the numbers on the payment card
    * [and more...](https://github.com/mayokunthefirst/CardInfoFinder/blob/master/buildSrc/src/main/kotlin/Dependencies.kt)
* Architecture
    * Clean Architecture (at module level)
    * MVVM (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
    * [Mockito](https://site.mockito.org/)
    * [Espresso](https://developer.android.com/training/testing/espresso)
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))
    
## Architecture
Clean Architecture is the "core architecture" of this application. The main purpose of this approach is to achieve a separation of concerns which Clean architecture helps with and in
making the code loosely coupled. This approach results in a more testable and flexible code. This approach divides the project in 3 modules: **presentation, data and domain**.

<p align="center"><a><img src="https://raw.githubusercontent.com/mayokunthefirst/CardInfoFinder/master/media/clean-arch.png" width="700"></a></p>

* **Presentation**: Layer with the Android Framework, the MVVM pattern and the DI module. Depends on domain to access the use cases and on DI, to inject dependencies. This is the layer closest 
to what the user sees on the screen. 
    - **MVVM**: The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. It combines very well with Android Architecture Components like LiveData and DataBinding.
* **Domain**: This is the core layer of the application with the business logic. It contains the use cases, in charge of calling the correct repository or data member.The domain layer is independent of any other layers. 
* **Data**: Layer with the responsibility of managing the application data and exposes these data sources as repositories to the domain layer. Typical responsibilities of this layer is to retrieve data from the internet and optionally cache this data locally.

### Dependency Injection with Koin
Dependency injection is closely related to two SOLID concepts: dependency inversion, which states that high level modules should not depend on low level modules, 
both should depend on abstractions; and single responsibility principle, 
which states that every class or module is responsible for just a single piece of functionality. This application makes use of Koin as a DI library.

### External dependencies
All the external dependencies (external libraries) are defined in the single place - Gradle `buildSrc` folder. This approach allows to easily manage dependencies and use the same dependency version across all modules.

## Installation
This project requires a minimum API level of 21. Clone the repository, build and run. You can also install the apk generated by GitHub Actions [here](https://github.com/mayokunthefirst/CardInfoFinder/actions) for a quick run.

## LICENSE
```
MIT License

Copyright (c) 2020 Mayokun Adeniyi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

    
