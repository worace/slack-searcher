(ns slack-searcher.views
  (:require [hiccup.core :as hic]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            [hiccup.form :as form]
            [hiccup.element :refer (link-to)]))

(defn with-template [inner]
  (hic/html [:html
             [:body
              inner]]))

(defn search-form
  []
  (form/form-to [:post "/search"]
                (anti-forgery-field)
                (form/label "query" "Enter query")
                (form/text-field "query")))

(defn index []
  (with-template [:div
                  (search-form)]))

(defn any-results? [results]
  (> (get-in results [:hits :total]) 0))

(defn render-results [results]
  [:div
   [:ul (for [r (get-in results [:hits :hits])]
          [:li (get-in r [:_source :text])])]])

(defn render-no-results []
  [:div
   [:p "sorry, no results matched your search"]])

(defn search [results]
  (with-template [:div
                  (if (any-results? results)
                    (render-results results)
                    (render-no-results))
                  [:p "Search again: "]
                  (search-form)]))
