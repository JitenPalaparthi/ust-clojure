(ns user-posts.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]))

(def db-spec {:dbtype "postgresql"
              :dbname "appdb"
              :host "localhost:5432"
              :user "app"
              :password "app123"})

(def ds (jdbc/get-datasource db-spec))

;; CRUD functions for `users` table
(defn create-user [user]
  (sql/insert! ds :users user))

(defn get-user [id]
  (sql/get-by-id ds :users id))

(defn update-user [id user]
  (sql/update! ds :users user {:id id}))

(defn delete-user [id]
  (sql/delete! ds :users {:id id}))

;; CRUD functions for `posts` table
(defn create-post [post]
  (sql/insert! ds :posts post))

(defn get-post [id]
  (sql/get-by-id ds :posts id))

(defn update-post [id post]
  (sql/update! ds :posts post {:id id}))

(defn delete-post [id]
  (sql/delete! ds :posts {:id id}))