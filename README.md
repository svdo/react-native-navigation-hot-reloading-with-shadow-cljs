Cogito Mobile App
=================

Goal
----
Make Shadow-CLJS-based hot reloading work with [React Native Navigation][1].

Status
------
* Hot Reloading works.
* React Native Navigation does not work (pressing button "press me" crashes app).

Problem to be solved
--------------------
The wrapper `reload-wrapper` in `app.cljs` is given a `componentId` prop by
React Native Navigation when it is registered (`.registerComponent Navigation ...`).
This componentId prop must be passed on to the wrapped component for 
React Native Navigation to work.

Development
-----------
* Watch & build ClojureScript source files: `yarn build:dev`
* Run tests: `yarn test`
* Run iOS version on simulator: `yarn ios` (also starts metro bundler)
* Run metro-bundler manually if desired: `yarn start`


[1]: https://github.com/wix/react-native-navigation
