# Rick-And-Morty
<br />This is only a sample project and can be modified every time it needs. 
<br />After All nothing are wrote in the stones.

# \[ 🚧 Work in progress 👷‍♀️⛏👷🔧️👷🔧 🚧 \] Rick and Morty App

# Implementation Details

MVVM pattern with Repository Pattern and inspired by the Clean.

- Model View View Model pattern (MVVM).
- Repository Pattern.
- Reactive Programming with RxJava2.
- Responsive UI.
- Retrofit + MOSHI.
- Databinding.
- Navigation Component.
- Material Design pattern in available time.
- Glide for image loading and Glide Module pattern.
- Dagger 2 for Dependency injection.
- Paging library.
- Rotation support and resizable screens.
- Kotlin DSL.
- Focus in performance.
- Mockito for Unit Testing.

**Modularized Projet:**
**The main packages:**
- **app:** Responsible for manifest merge, and permissions part.
- **core:** Responsible for all commons files in the project.
- **di:** Responsible for all dependency injection in the project.
- **buildSrc:** Responsible for all Gradle Dependency Management. 

**Modules For Features:**
- **home:** Responsible for navigation part and Bottom Navigation.
- **episodes:** Responsible for all episodes module.
- **characters:** Responsible for all characters module.

<img src="https://github.com/renatoramos7/Rick-And-Morty/blob/master/design/Screenshot4.png" width="300">

### Model View View Model
Model, View, View and Model, Unit Tests and Modularized responsibility layers.

### UX / UI
Material Design pattern in available time.

<img src="https://github.com/renatoramos7/Rick-And-Morty/blob/master/design/Screenshot1.jpg" width="300">
<img src="https://github.com/renatoramos7/Rick-And-Morty/blob/master/design/Screenshot2.jpg" width="300">
<img src="https://github.com/renatoramos7/Rick-And-Morty/blob/master/design/Screenshot3.jpg" width="300">

### Libraries

1.  **RxJava2 + RxAndroid2:** This is the best way to work asynchronously and maintain the application scalable.
2.  **Retrofit2 + OkHttp:** For Network Request and Rx integration.
3.  **Navigation Component:** For Integration with screens.
4.  **Databinding:** For view binding.
5.  **Glide:** For image loading.
6.  **Moshi:** Retrofit integration for deserialize.
7.  **Paging library:** For Paging in RecyclerView.
8.  **Dagger2:** For dependency injection.
9.  **PaperDb:** For cache.
10. **Kotlin DSL** For BuildSrc and Gradle Dependency Management.

### Installing
Just have the project and clean and build in your Android Studio

## Versioning

We are using [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/renatoramos7/Rick-And-Morty). 

## Author

* **Renato Ramos** - *Initial work*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details