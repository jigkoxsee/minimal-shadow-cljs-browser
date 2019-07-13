
(ns app.main
  (:require [app.lib :as lib]
            [reagent.core :as reagent :refer [atom]]
            [goog.string :as gstring]
            [goog.object :as gobj]
            [goog.string.format]
            [re-frame.core :as rf]
            [clojure.string :as string]))

(def a 1)

(defonce b 2)

;;--------------
(rf/reg-event-db              ;; sets up initial application state
  :initialize                 ;; usage:  (dispatch [:initialize])
  (fn [_ _]                   ;; the two parameters are not important here, so use _
    {:time (js/Date.)         ;; What it returns becomes the new application state
     :time-color "#f88"}))    ;; so the application state will initially be a map with two keys

;;--------------



(defn main-panel []
  [:div
    [:h2 "hello"]
    [:div
     [:p "world"]]])


(defn init []
  (reagent/render-component [main-panel] (. js/document (getElementById "app"))))


(defn main! []
  (println "[main]: loading")
  (rf/dispatch-sync [:initialize])
  (init))


(defn reload! []
  (println "[main] reloaded lib:" lib/c lib/d)
  (println "[main] reloaded:" a b)
  (init))
 
