## Clean Architecture (MVVM)

# Highlights

- Clean Architecture (MVVM)
- Multimodular Application Architecture
- Coroutine and Flow for asynchronous operation and reactive streams
- Single Activity Architecture
- Dependency Injection with Hilt
- Implement Detekt for static code analysis
- Database with Room
- Navigation Graph

# Architecture

The architecture of the application strictly complies the following points.

- A single-activity architecture, using the Navigation component to manage fragment operations.
- Android architecture components, part of Android Jetpack for give to project a robust design,
  testable and maintainable.
- Model-View-ViewModel (MVVM) facilitating a separation of development of the graphical user
  interface.
- S.O.L.I.D design principles intended to make software designs more understandable, flexible and
  maintainable.
- Modular app architecture allows to be developed features in isolation, independently from other
  features.

## Modules

<img src="/screenshot/app_flow_diagram.png" alt="Home"/>

- Application modules load all features modules(:core,:base,:framework,:features).
- :base module is one of the main module in the application, where you can find all the common
  implementation. It contains the base classes + utils classes.
- :core and :framework modules contains all business logic.
  :core module is completely a kotlin module and its independent of any other component in the
  architecture. The :core module contains all the business use cases and also it has the abstraction
  of the data repository.
  :framework module contains all the implementation of data repository, network, dependency
  injection and room database.
- :features modules represents various features in the application. Each feature module can be
  delivered as dynamic feature modules in future if needed. Each of the feature module depends on
  core module and base module.

## Tech stack

- [Jetpack](https://developer.android.com/jetpack):
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - provide concise, idiomatic
      Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - major improvement to the original
      Android [Support Library](https://developer.android.com/topic/libraries/support-library/index)
      , which is no longer maintained.
    - [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - allows you to
      bind UI components in your layouts to data sources in your app using a declarative format
      rather than programmatically.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform
      actions in response to a change in the lifecycle status of another component, such as
      activities and fragments.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) -
      lifecycle-aware, meaning it respects the lifecycle of other app components, such as
      activities, fragments, or services.
    - [Navigation](https://developer.android.com/guide/navigation/) - helps you implement
      navigation, from simple button clicks to more complex patterns, such as app bars and the
      navigation drawer.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - designed
      to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows
      data to survive configuration changes such as screen rotations.
    - [Room](https://developer.android.com/training/data-storage/room) - Room - persistence library
      provides an abstraction layer over SQLite to allow for more robust database access while
      harnessing the full power of SQLite.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - managing background
  threads with simplified code and reducing needs for callbacks.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency
  injector for replacement all Factory classes.
- [Retrofit](https://square.github.io/retrofit/) - type-safe HTTP client.
- [GSON](https://github.com/google/gson) - Gson is a Java library that can be used to convert Java
  Objects into their JSON representation. It can also be used to convert a JSON string to an
  equivalent Java object.
- [DeteKt](https://github.com/detekt/detekt) - use for static code analysis.



