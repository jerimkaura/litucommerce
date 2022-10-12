### Litu
Trying out E-Commerce platform using Jetpack compose

#### Project characteristics

This project brings to table set of best practices, tools, and solutions:

* Jetpack Compose
* 100% Kotlin
* Model-View-View Model Architecture
* Dependency Injection
* Material design
* Room local persistence
* Network Bound Resource
* Light Theme and Dark Theme

#### Tech-stack

This project takes advantage of many popular libraries and tools of the Android ecosystem. Most of
the libraries are in the stable version.

* Tech-stack
    * [Jetpack Compose](https://kotlinlang.org/) - Android’s modern toolkit for building native UI.
    * [Kotlin](https://kotlinlang.org/)
        + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - To perform
          background operations
    * [Dagger Hilt](https://dagger.dev/hilt/) - For dependency injection
    * [Jetpack](https://developer.android.com/jetpack)
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) -
          Performs various actios when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores
          and manages UI-related data
    * [Retrofit](https://github.com/square/retrofit) for making network calls.
* Architecture
    * [MVVM](https://developer.android.com/jetpack/guide?gclid=CjwKCAiAvaGRBhBlEiwAiY-yMLJgFw8dtzM8r78wKMlnykKhTDwh5vx4ZOGqGBbXQ8PEFlYsS_b_oBoCRGoQAvD_BwE&gclsrc=aw.ds)
        - Makes it easier to write modular, reusable and easy to test code
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture). An app architecture defines the boundaries between parts of the app and the responsibilities each part should have.
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  
#### Getting started

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/jerimkaura/Litu.git` into URL field

### Application screenshots

#### Light Theme

Login Screen           |                    Register Screen                    |                   Drawer                   |
:-------------------------:|:-----------------------------------------------------:|:------------------------------------------:|
![Onboarding Screen 1  ](images/login-light.png)  |   ![  Register Screen ](images/register-light.png)    |     ![Drawer](images/drawer-light.png)     | 
Home screen          |                    Product Details                    |                 Favourites                 |
![Home screen  ](images/home-light.png)  | ![ Product Details](images/product-details-light.png) | ![Favourites](images/favourites-light.png) | 

#### Dark Theme
Login Screen           |                 Register Screen                  |                   Drawer                   |
:-------------------------:|:------------------------------------------------:|:------------------------------------------:|
![Login Screen ](images/login-dark.png)  |  ![Register Screen ](images/register-dark.png)   |    ![ Drawer  ](images/drawer-dark.png)    | 
Home Screen        |                 Product Details                  |                 Favourites                 |
![Save Username ](images/home-dark.png)  | ![Home Page   ](images/product-details-dark.png) | ![Favourites ](images/favourites-dark.png) | 


#### License

 ```
 MIT License
 
 Copyright (c) 2022 Jerim Kaura
 
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 associated documentation files (the "Software"), to deal in the Software without restriction, including 
 without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to 
 the following conditions:
 
 The above copyright notice and this permission notice shall be included in all copies or substantial 
 portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN 
 NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 WHETHER IN AN ACTION OF  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
 SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ```
