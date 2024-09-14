(ns users-posts-project.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [users-posts-project.routes :refer [user-routes]]
   [ring.middleware.json :refer [wrap-json-response]]
  ))

(def app
  (wrap-json-response user-routes))

(defn -main []
  (run-jetty app {:port 3000 :join? false}))

