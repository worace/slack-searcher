(ns slack-searcher.search
  (:require  [clojurewerkz.elastisch.query :as q]
             [clojurewerkz.elastisch.rest :as esr]
             [clojurewerkz.elastisch.rest.document :as esd]))

(def es-conn (esr/connect "http://127.0.0.1:9200"))
(def index-name "slack_slurper")
(def mapping-name "messages")
(def query (partial esd/search es-conn index-name mapping-name :query))

(defn search [term]
  (query (q/term :text term)))

(defn all []
  (query (q/match-all)))

