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

(defn update-user-status [id status]
  (sql/update ds :users {:status status} {:id id})
  )

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

(defn update-post-status [id status]
  (sql/update ds :posts {:status status} {:id id}))

(defn delete-post [id]
  (sql/delete ds :posts {:id id})
  )

(defn get-post-by-user [user-id]
  (sql/query ds  ["SELECT * FROM posts where user_id = ?" user-id])
  )

(defn get-all-posts-with-user []
  (sql/query ds ["SELECT posts.id as post_id, posts.body, posts.title,posts.status,posts.last_updated,
            users.id as user_id,users.username,users.email,users.status,users.last_updated FROM posts
                  INNER JOIN users ON posts.user_id=users.id"]))

(defn get-all-active-posts-with-user []
  (sql/query ds ["SELECT posts.id as post_id, posts.body, posts.title,posts.status,posts.last_updated,
            users.id as user_id,users.username,users.email,users.status,users.last_updated FROM posts
                  INNER JOIN users ON posts.user_id=users.id WHERE users.status='active' AND posts.status='active'"]))

(defn get-all-posts-after [date]
  (sql/query ds ["SELECT * FROM posts where last_updated > ?",date])
  )
;; (get-all-posts-after "2024-08-01") ;; yyyy-mm-dd

;; 1. do these operations for mysql
;; 2. insert operation, should return only the id, refer demo46
;; 3. make sure that the data is inserted into the database
;; 4. get posts which are not active/inactive
;; 5. get users who are active/inactive
;; 6. get all posts between two dates 
