(ns clojure-webapp.views
  (:require [clojure.string :as str]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Root"]
   " | "
   [:a {:href "/info"} "Info"]
   " ]"])

(defn root
  []
  (page/html5
   (gen-page-head "Root")
   header-links
   [:h1 "Welcome to this Basic Application"]
   [:p "First time using this language, framework, and technology."]))

(defn info
  []
  (page/html5
   (gen-page-head "Info")
   header-links
   [:h1 "Info"]
   [:p "Webapp to try Clojure for the first time"]))


; (defn add-location-page
;   []
;   (page/html5
;    (gen-page-head "Add a Location")
;    header-links
;    [:h1 "Add a Location"]
;    [:form {:action "/add-location" :method "POST"}
;     (util/anti-forgery-field) ; prevents cross-site scripting attacks
;     [:p "x value: " [:input {:type "text" :name "x"}]]
;     [:p "y value: " [:input {:type "text" :name "y"}]]
;     [:p [:input {:type "submit" :value "submit location"}]]]))
;
; (defn add-location-results-page
;   [{:keys [x y]}]
;   (let [id (db/add-location-to-db x y)]
;     (page/html5
;      (gen-page-head "Added a Location")
;      header-links
;      [:h1 "Added a Location"]
;      [:p "Added [" x ", " y "] (id: " id ") to the db. "
;       [:a {:href (str "/location/" id)} "See for yourself"]
;       "."])))
;
; (defn location-page
;   [loc-id]
;   (let [{x :x y :y} (db/get-xy loc-id)]
;     (page/html5
;      (gen-page-head (str "Location " loc-id))
;      header-links
;      [:h1 "A Single Location"]
;      [:p "id: " loc-id]
;      [:p "x: " x]
;      [:p "y: " y])))
;
; (defn all-locations-page
;   []
;   (let [all-locs (db/get-all-locations)]
;     (page/html5
;      (gen-page-head "All Locations in the db")
;      header-links
;      [:h1 "All Locations"]
;      [:table
;       [:tr [:th "id"] [:th "x"] [:th "y"]]
;       (for [loc all-locs]
;         [:tr [:td (:id loc)] [:td (:x loc)] [:td (:y loc)]])])))
