(ns status-im.ui.screens.go-live.views
  (:require-macros [status-im.utils.views :as views])
  (:require [status-im.ui.components.toolbar.view :as toolbar]
            [reagent.core :as reagent]
			[goog.object :as object]
			[status-im.react-native.js-dependencies :as js-dependencies]
            [status-im.ui.components.react :as react]
            [status-im.ui.components.status-bar.view :as status-bar]
            [status-im.i18n :as i18n]
            [status-im.ui.screens.profile.components.views :as profile.components]
            [re-frame.core :as re-frame]))

(defn get-property [name]
    (object/get js-dependencies/media-client name))

(defn adapt-class [class]
    (when class
        (reagent/adapt-react-class class)))

(defn get-class [name]
    (adapt-class (get-property name)))


(def media-client 
    (get-class "NodeCameraView"))

(views/defview go-live []
	[react/view {:flex 1}
        [media-client
        {
              :style { :height 400 :width 400 }
			  :ref (fn [this vp] (object/set this "vp" vp))
              :camera { :cameraId 1 :cameraFrontMirror true }
              :inputUrl "rtmp://"
              :scaleMode "ScaleAspectFit"
              :bufferTime 300
              :maxBufferTime 1000
              :autoplay true
        }]
    ;  [status-bar/status-bar]
    ;  [toolbar/simple-toolbar (i18n/label :t/about-app)]
    ;  [react/scroll-view
    ;   [react/view
    ;    [profile.components/settings-item-separator]
    ;    [profile.components/settings-item
    ;     {:label-kw            :t/privacy-policy
    ;      :accessibility-label :privacy-policy
    ;      :action-fn           #(re-frame/dispatch [:privacy-policy/privacy-policy-button-pressed])}]
    ;    (when status-im.utils.platform/ios?
    ;      [profile.components/settings-item-separator])
    ;    [profile.components/settings-item
    ;     {:item-text           (i18n/label :t/version {:version version})
    ;      :accessibility-label :version
    ;      :hide-arrow?         true}]]]
         ])
