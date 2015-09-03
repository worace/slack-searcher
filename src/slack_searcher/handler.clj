(ns slack-searcher.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [slack-searcher.views :as views]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (views/index))
  (POST "/search" [query] query)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc site-defaults :security {:anti-forgery true})))
