(ns demo43.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]))

(defn hello-world-handler []
  (response/response "Hello, World!"))
(defn greet-handler [name]
  (response/response (str "Hello," name)))
(defn post-handler [request] 
  (let [body (:body request)
    params (slurp body)]
    (response/response (str "Received data:" params))
    )
  )
(defroutes app-routes
  (GET "/" [] (hello-world-handler))
  (GET "/greet/:name" [name] (greet-handler name))
  (GET "/books/:id" [id] (response/response (str "Hello, you are trying to access this book id:" id)))
  (POST "/submit" request (post-handler request))
  (route/not-found "Not Found"))
(defn -main
  [& args]
  (jetty/run-jetty app-routes {:port 58081 :join? false})
  )
