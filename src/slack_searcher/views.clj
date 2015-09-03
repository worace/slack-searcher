(ns slack-searcher.views
  (:require [hiccup.core :as hic]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            [hiccup.form :as form]))

(defn with-template [inner]
  (hic/html [:html
             [:body
              inner]]))

(defn index []
  (with-template [:div
                  (form/form-to [:post "/search"]
                                (anti-forgery-field)
                                (form/label "query" "Enter query")
                                (form/text-field "query"))]))


