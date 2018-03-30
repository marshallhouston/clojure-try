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
