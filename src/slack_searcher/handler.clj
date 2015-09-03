(ns slack-searcher.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [slack-searcher.views :as views]
            [slack-searcher.search :as s]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (views/index))
  (POST "/search" [query] (views/search (s/search query)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc site-defaults :security {:anti-forgery true})))
