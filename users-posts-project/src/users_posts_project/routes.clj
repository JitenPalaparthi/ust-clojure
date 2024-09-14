(ns users-posts-project.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [users-posts-project.db :as db]
            [cheshire.core :as cheshire]
            [ring.util.response :refer [response status] ]
            [clojure.data.json :as json])
   (:import (java.io StringReader)))


(defn json-read [body]
  (json/read (StringReader. body) :key-fn keyword)) ;; Convert String to StringReader and then read JSON


(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (cheshire/generate-string data)})

(defroutes user-routes
  (GET "/users" [] (json-response (db/get-all-users)))
  (GET "/users/:id" [id]  (json-response (db/get-user (Integer. id))))
  (POST "/users" req
    (let [user-data (json-read (slurp (:body req)))  ;; Read JSON from body and convert to map
          inserted (db/create-user user-data)]       ;; Insert user into DB
      (status (response {:message "User created successfully", :user inserted}) 201))))
  
