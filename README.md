[![Maven Central](https://img.shields.io/maven-central/v/com.saadahmedev.popup-dialog/popup-dialog.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.saadahmedev.popup-dialog%22%20AND%20a:%22popup-dialog%22)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat"/></a>
<a href="https://github.com/saadahmedscse/shortintent"><img alt="API" src="https://badges.frapsoft.com/os/v1/open-source.png?v=103"/></a>
<a href="https://github.com/saadahmedscse/shortintent/graphs/traffic"><img alt="Total Clones" src="https://img.shields.io/badge/Clones-126-orange"/></a>
<a href="[https://github.com/rrsaikat/CodeChallengeByShikho/graphs/traffic](https://github.com/saadahmedscse/shortintent/graphs/traffic)"><img alt="Total Views" src="https://img.shields.io/badge/Views-382-brightgreen"/></a>

# Android Popup Dialog
Getting tired by writing and coding default progress bar and custom popup dialog? Android Popup Dialog is a lightweight and easy to use Android library that provides you to make many kinds of dialog [Popup and Progress] by writing just some lines code. You don't have to design manually. You can customize every dialog and every properties of it's manually.
* Min SDK 21 (Android Kitkat 5.0)
* Written in Java
* Compatible for both Java and Kotlin

## Features
* Default circular progress bar dialog
* Android default alert dialog
* IOS default popup dialog
* Stylish standard dialog
* Progress dialog with lottie animation
* Success dialog
* Alert dialog
* Failed dialog

## Installation

Add the dependency to your module build.gradle:
```groovy
dependencies {
    ...
    implementation 'com.saadahmedev.popup-dialog:popup-dialog:1.0.0'
}
```

## Usage
### Styles :
`Styles.PROGRESS`  
`Styles.IOS`  
`Styles.ANDROID_DEFAULT`  
`Styles.STANDARD`  
`Styles.LOTTIE_ANIMATION`  
`Styles.SUCCESS`  
`Styles.FAILED`  
`Styles.ALERT`  

### Implementation :
<table>
<tr>
<th> PROGRESS </th>
<th> Result </th>
</tr>
<tr>
<td width="650px">

```java
PopupDialog.getInstance(this)
        .setStyle(Styles.PROGRESS) //Required
        .setProgressDialogTint(R.color.color_red) //Non-Required
        .setCancelable(false) //Non-Required
        .showDialog(); //Show dialog
```

</td>
<td>

<img src ="popupDialog/demos/dialog_progress.gif" height="250px" width="335"/>

</td>
</tr>
</table>

<table>
<tr>
<th> LOTTIE_ANIMATION </th>
<th> Result </th>
</tr>
<tr>
<td width="650px">

```java
PopupDialog.getInstance(this)
        .setStyle(Styles.LOTTIE_ANIMATION) //Required
        .setLottieAssetName("technologies.json") //Required if no RawRes
        .setLottieRawRes(R.raw.technologies) //Required if no Asset
        .setCancelable(false) //Non-Required
        .showDialog(); //Show Dialog
```

</td>
<td>

<img src ="popupDialog/demos/dialog_lottie_animation.gif" height="250px" width="335"/>

</td>
</tr>
</table>

<table>
<tr>
<th> STANDARD </th>
<th> Result </th>
</tr>
<tr>
<td width="650px">

```java
PopupDialog.getInstance(this)
    .setStyle(Styles.STANDARD) //Required
    .setHeading("Logout") //Required
    .setHeading("Are you sure you want to logout?"+
        " This action cannot be undone") //Required
    .setPopupDialogIcon(R.drawable.ic_logout) //Required
    .setPopupDialogIconTint(R.color.color_red) //Non-Required
    .setCancelable(false) //Non-Required
    .showDialog(new OnDialogButtonClickListener() { //Required
        @Override
        public void onPositiveClicked(Dialog dialog) { //Required
            super.onPositiveClicked(dialog);
        }

        @Override
        public void onNegativeClicked(Dialog dialog) { //Required
            super.onNegativeClicked(dialog);
        }
    }); //Show Dialog
```

</td>
<td>

<img src ="popupDialog/demos/dialog_lottie_animation.gif" height="250px" width="335"/>

</td>
</tr>
</table>

## License
```
Copyright 2022 Saad Ahmed

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
