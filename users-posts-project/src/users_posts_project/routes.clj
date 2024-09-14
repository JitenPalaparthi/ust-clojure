(ns users-posts-project.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [users-posts-project.db :as db]
            [cheshire.core :as cheshire]
            [ring.util.response :refer [response status]]
            [clojure.data.json :as json])
  (:import (java.io StringReader)))


(defn json-read [body]
  (json/read (StringReader. body) :key-fn keyword)) ;; Convert String to StringReader and then read JSON


(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (cheshire/generate-string data)})

(defn create-user [req]
  (let [user-data (json-read (slurp (:body req)))
        inserted (db/create-user user-data)]
    (status (response {:message "User created successfully", :user inserted}) 201)))

;; PUT route for updating a user
(defn update-user [req]
  (let [user-data (json-read (slurp (:body req)))
        user-id (get-in req [:params :id])]
    (db/update-user user-id user-data) ;; Calls the update function from db
    (response {:message (str "User " user-id " updated successfully.")})))

;; DELETE route for deleting a user
(defn delete-user [req]
  (let [user-id (get-in req [:params :id])]
    (db/delete-user user-id) ;; Calls the delete function from db
    (response {:message (str "User " user-id " deleted successfully.")})))

;; GET route for retrieving all users
(defn get-all-users []
  (let [users (db/get-all-users)]
    (response {:users users})))

;; GET route for retrieving a specific user by ID
(defn get-user [req]
  (let [user-id (get-in req [:params :id])
        user (db/get-user user-id)]
    (if user
      (response {:user user})
      (status (response {:message "User not found"}) 404))))

(defroutes user-routes
  (GET "/users" [] (json-response (db/get-all-users)))
  (GET "/users/:id" [id]  (json-response (db/get-user (Integer. id))))
  ;; (GET "/users" [] (get-all-users))       ;; Get all users 
  ;; (GET "/users/:req" req (get-user req))     ;; Get specific user by ID
  (POST "/users" req (create-user req))
  (PUT "/users/:req" req (update-user req)) ;; Use user ID in the route
  (DELETE "/users/:req" req (delete-user req))) ;; Use user ID in the route
