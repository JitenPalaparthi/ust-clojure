(ns users-posts-project.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]]
            [users-posts-project.db :as db]
            [cheshire.core :as cheshire]
            [ring.util.response :refer [response status]]
            [clojure.data.json :as json])
  (:import (java.io StringReader)))


(defn json-read [body]
  (json/read (StringReader. body) :key-fn keyword)) ;; Convert String to StringReader and then read JSON

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

;; PUT route for updating a user's status
(defn update-user-status [req]
   (let [user-id (get-in req [:params :id])  ;; Get the user ID from the URL
            ]        ;; Convert user ID to integer
     (if user-id
       (let [user-data (json/read-str (slurp (:body req)) :key-fn keyword)  ;; Read the JSON body
             status-field (get user-data :status)]                                 ;; Extract status from the body 
         (if (nil? status-field)
           (status (response {:message "Status field is required"}) 400)
           (do
             (db/update-user-status user-id status-field)                         ;; Call database function to update status
             (response {:message (str "User " user-id " status updated to " status-field)})) ;; Return success message
          ;; If status is missing, return a 400 response
           ))
      ;; If user ID is invalid, return a 400 response
       (status (response {:message "Invalid user ID"}) 400))))

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
  (GET "/users" [] (get-all-users))       ;; Get all users  
  (GET "/users/:id" id (get-user id))     ;; Get specific user by ID
  (POST "/users" req (create-user req))
  (PUT "/users/:id" id (update-user id)) ;; Use user ID in the route 
  (PUT "/users/:id/status" req (update-user-status req)) ;; Use user ID in the route
  (DELETE "/users/:id" id (delete-user id))) ;; Use user ID in the route
