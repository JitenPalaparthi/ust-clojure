(ns demo39.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.util.response :refer [response]]))

(defn handler [request]
  (response "Hello World!"))

(defn -main
  [& args]
  (run-jetty handler {:port 8081 :join? false})
  )
