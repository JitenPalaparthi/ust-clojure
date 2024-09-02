(ns demo42.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as response]))

;; Define GET handler
(defn get-handler []
  (response/response "Hello, World!"))

;; Define POST handler
(defn post-handler [request]
  (let [body (:body request)
        params (slurp body)]
    (response/response (str "Received POST data: " params))))

;; Define the routes
(defroutes app-routes
  (GET "/" [] (get-handler))
  (POST "/submit" request (post-handler request))
  (route/not-found "Not Found"))

;; Run the server
(defn -main []
  (jetty/run-jetty app-routes {:port 3000 :join? false}))