# react-native-dimmer

A plugin that allows you to enable (eventually lock the device)
and disable the screen dim in your React Native app.
Works in both iOS and Android.

[![github home](https://img.shields.io/badge/YADI%20Social-react--native--dimmer-green.svg?style=flat-square)](https://github.com/yadi-social/react-native-dimmer)
[![github issues](https://img.shields.io/github/issues/yadi-social/react-native-dimmer.svg?style=flat-square)](https://github.com/yadi-social/react-native-dimmer/issues)
[![npm version](https://img.shields.io/npm/v/react-native-dimmer.svg?style=flat-square)][npm-package]
[![npm downloads](https://img.shields.io/npm/dm/react-native-dimmer.svg?style=flat-square)][npm-package]
[![npm license](https://img.shields.io/npm/l/react-native-dimmer.svg?style=flat-square)][npm-package]

-   [Installation](#installation)
-   [Usage](#usage)
-   [License](#license)

---

## Installation

`$ npm install react-native-dimmer --save`

### iOS

In the XCode's "Project navigator", right click on your project's
"Libraries" folder ➜ `Add Files to <...>`.
Go to `node_modules` ➜ `react-native-dimmer` ➜ select the contents
of `ios` folder. Make sure `RNDimmer.m` is listed under "Compile Sources"
in your project's "Build Phases" tab.

### Android

Add `react-native-dimmer` to your `./android/settings.gradle` file as follows:

```text
include ':react-native-dimmer'
project(':react-native-dimmer').projectDir = new File(settingsDir, '../node_modules/react-native-dimmer/android')
```

Include it as dependency in `./android/app/build.gradle` file:

```text
dependencies {
    ...
    compile project(':react-native-dimmer')
}
```

Finally, you need to add the package within the `ReactInstanceManager` of your
MainActivity (`./android/app/src/main/java/your/bundle/MainActivity.java`):

```java
import social.yadi.rndimmer.ReactNativeDimmerPackage;  // <---- import this one
...
@Override
protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        new MainReactPackage(),
        new ReactNativeDimmerPackage(this)  // <---- add this line
    );
}
```

After that, you will need to recompile
your project with `react-native run-android`.

## Usage

```js
import React, { Component } from 'react-native';
import RNDimmer from 'react-native-dimmer';
...
class Application extends Component {
    ...
    componentWillMount() {
        // Enable dimmer
        this.applyDimmer();
    }
    componentWillUnmount() {
        // Disable dimmer
        this.applyDimmer( false );
    }
    async applyDimmer( disabled = true ) {
        try {
            await RNDimmer.set( disabled );
            console.log( disabled ? 'Enabled' : 'Disabled' );
        } catch ( e ) {
            console.error( e );
        }
    }
    ...
}
```

## License

[The MIT License](../master/LICENSE)

[npm-package]: https://www.npmjs.com/package/react-native-dimmer
