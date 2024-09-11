(ns user-posts.handler
  (:require [compojure.core :refer :all]
            [ring.middleware.json :as middleware]
            [ring.util.response :refer :all]
            [user-crud.db :as db]
            [clojure.tools.logging :as log]))

;; Routes for Users
(defroutes user-routes
  (POST "/users" req
    (let [user (-> req :body)]
      (log/info "Creating user" user)
      (db/create-user user)
      (response {:status "User created"})))

  (GET "/users/:id" [id]
    (log/info "Fetching user" id)
    (if-let [user (db/get-user (Integer/parseInt id))]
      (response user)
      (response {:status "User not found"})))

  (PUT "/users/:id" req
    (let [id (Integer/parseInt (-> req :params :id))
          user (-> req :body)]
      (log/info "Updating user" id)
      (db/update-user id user)
      (response {:status "User updated"})))

  (DELETE "/users/:id" [id]
    (log/info "Deleting user" id)
    (db/delete-user (Integer/parseInt id))
    (response {:status "User deleted"})))

;; Routes for Posts
(defroutes post-routes
  (POST "/posts" req
    (let [post (-> req :body)]
      (log/info "Creating post" post)
      (db/create-post post)
      (response {:status "Post created"})))

  (GET "/posts/:id" [id]
    (log/info "Fetching post" id)
    (if-let [post (db/get-post (Integer/parseInt id))]
      (response post)
      (response {:status "Post not found"})))

  (PUT "/posts/:id" req
    (let [id (Integer/parseInt (-> req :params :id))
          post (-> req :body)]
      (log/info "Updating post" id)
      (db/update-post id post)
      (response {:status "Post updated"})))

  (DELETE "/posts/:id" [id]
    (log/info "Deleting post" id)
    (db/delete-post (Integer/parseInt id))
    (response {:status "Post deleted"})))

;; Combine all routes
(def app
  (-> (routes user-routes post-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))