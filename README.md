<h1 align="center">CardScratch</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <img alt="API" src="https://img.shields.io/badge/Api%2024+-50f270?logo=android&logoColor=black&style=for-the-badge"/></a>
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-a503fc?logo=kotlin&logoColor=white&style=for-the-badge"/></a>
  <img alt="Jetpack Compose" src="https://img.shields.io/static/v1?style=for-the-badge&message=Jetpack+Compose&color=4285F4&logo=Jetpack+Compose&logoColor=FFFFFF&label="/></a>


CardScratching is an Android library that empowers app developers to integrate an interactive scratch card feature into their applications. With CardScratching, users can virtually 'scratch' a card on their device's screen, revealing concealed content underneath. This content is often used to showcase coupon codes, discounts, or other rewards, enhancing user engagement and creating an enjoyable interaction. The library offers customization options for the scratch card's appearance, making it easy to match the app's design. By leveraging CardScratching, developers can seamlessly introduce gamified elements to their apps, resulting in increased user interaction and satisfaction.

- **Interactive Scratching:** The library provides a touch-sensitive interface that simulates the act of scratching a surface to unveil hidden information.
- **Customizable Design:** Developers can customize the appearance of the scratch card, including its size, shape, colors, and text.
- **Revealing Content:** Underneath the scratched area, the library reveals content such as a coupon code, discount information, or any other rewards.
- **User Engagement:** The scratch card feature adds an element of gamification and user engagement to the application, encouraging users to interact with the app to reveal hidden rewards.
- **Integration:** The library can be integrated easily into existing Android apps, providing developers with a pre-built solution for adding scratch card functionality.



![Version](https://img.shields.io/badge/version-1.0-blue)
![API](https://img.shields.io/badge/Api-24+-yellow)

## Preview

<p align="center">
<img src="assets/card.gif" width="280"/>
</p>


<p align="center">
<img src="assets/scratch.gif" width="280"/>
</p>

## Adding the library to your project✨
Add the followings to your project level `build.gradle` file.
```groovy
dependencies {
  implementation 'com.github.JaberAhamed:CardScratch:1.0'
}
```

Add the following to your **root** `build.gradle` file:
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```


### Requirements

**1.** Minimum SDK for this library is **API 24**.

## Usage
For the **ImageScratch** you have to pass two image bitmap arguments for the overly and base image. The base image will show after the scratch.
```
ImageScratch(
              overlayImage = ImageBitmap.imageResource(R.drawable.overlay),
              baseImage =
              ImageBitmap.imageResource(R.drawable.base),
          )
```

For the **CardScratch** you have to pass *title* and *scratchText* as your requirements. The *scratchText* will show after the scratch.

```
CardScratch(
            cardBackgroundColor = Color.Red.copy(0.6f),
            title = "Scratch & Win",
            titleTextColor = Color.White,
            scratchText = "Coupon code is: 457896",
        )
```

## Find this library useful? ❤️

Give a ⭐️ if this project helped you!



## License

```
Copyright 2021 JABER BIN AHAMED

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
