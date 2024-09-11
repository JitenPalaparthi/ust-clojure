(ns users-posts-project.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]))

(def db-spec {:db-type "postgres"
              :dbname "appdb"
              :host "localhost:5432"
              :user "app"
              :password "app123"})
(def ds (jdbc/get-datasource db-spec))

(defn create-user [user]
  (sql/insert ds :users user))

(defn update-user [id user]
  (sql/update ds :users user {:id id}))

(defn delete-user [id]
  (sql/delete ds :users {:id id}))

(defn get-user [id]
  (sql/get-by-id ds :users id)
  )

(defn create-post [post]
  (sql/insert ds :posts post)
  )

(defn update-post [id post]
  (sql/update ds :posts post {:id id})
  )

(defn delete-post [id]
  (sql/delete ds :posts {:id id})
  )

(defn get-post-by-user [user-id]
  (sql/query ds  ["SELECT * FROM posts where user_id = ?" user-id])
  )

;; 1. 