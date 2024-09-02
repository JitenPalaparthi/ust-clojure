(ns demo40.core
  (:gen-class)
  (:require [cheshire.core :as json])
  )

(defn -main 
  [& args]

  (let [json-data (slurp "data.json")
        parse-data (json/parse-string json-data false)] 
    (println "json format:" parse-data)
    (println "type:" (type parse-data))
    )
  )
