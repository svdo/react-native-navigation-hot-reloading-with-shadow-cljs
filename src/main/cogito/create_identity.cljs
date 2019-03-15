(ns cogito.create-identity
  (:require
   [reagent.core :as r :refer [atom]]
   ["react-native" :as rn]
   ["react-native-navigation" :as ReactNativeNavigation :refer (Navigation)]
   [cogito.toolbar-button :as btn :refer [toolbar-button]]))

(def platform (.-Platform rn))

(defn screen-layout []
  [:> rn/View {:style {:flex-direction "column"
                       :margin 40
                       :align-items "center"}}

   [:> rn/Text {:style {:font-size 30
                        :font-weight "100"
                        :margin-bottom 20
                        :text-align "center"}}
    "Create Identity"]])

(defn screen []
  (r/create-class
   {:display-name "create-identity"

    :get-initial-state
    (fn [this]
      (let [events (.events Navigation)]
        (.bindComponent events this)))

    :reagent-render screen-layout

    :navigation-button-pressed
    (fn [props]
      (.dismissModal Navigation (.-componentId props)))}))

(defn presentation-options []
  (if (= "ios" (.-OS platform))
    {:topBar {:leftButtons
              [(toolbar-button "cancel")]}}
    {:topBar {:visible false
              :drawBehind true}}))

(def modal-presentation-layout
  (clj->js {:stack {:children
                    [{:component {:name
                                  "CreateIdentity"

                                  :options
                                  (presentation-options)}}]}}))
