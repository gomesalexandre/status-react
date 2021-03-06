(ns status-im.desktop.platform)

(def fonts-macos
  {:default       {:font-family "SFProText-Regular"}
   :medium        {:font-family "SFProText-Medium"}

   :toolbar-title {:font-family "SFProText-Regular"}
   :monospace     {:font-family "RobotoMono-Medium"}})

(def fonts-linux
  {:default       {:font-family "Arial" :font-weight "400"}
   :medium        {:font-family "Arial" :font-weight "800"}

   :toolbar-title {:font-family  "Arial" :font-weight "400"}
   :monospace     {:font-family "RobotoMono-Medium"}})

;; Structure to be exported

(defn platform-specific [macos]
  {:fonts                        (if macos fonts-macos fonts-linux)
   :tabs                         {:tab-shadows? true}
   :chats                        {:action-button?       true
                                  :new-chat-in-toolbar? false
                                  :render-separator?    false}
   :contacts                     {:action-button?          true
                                  :new-contact-in-toolbar? false}
   :group-block-shadows?         true
   :discover                     {:uppercase-subtitles? false}
   :status-bar-default-height    25})
