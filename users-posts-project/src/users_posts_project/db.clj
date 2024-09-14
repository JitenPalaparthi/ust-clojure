(ns users-posts-project.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]))

(def db-spec {:dbtype "postgres"
              :dbname "appdb"
              :host "localhost"
              :port 5432
              :user "app"
              :password "app123"})
(def ds (jdbc/get-datasource db-spec))

(defn parse-id [id-str]
  (try
    (Integer/parseInt id-str)
    (catch NumberFormatException e
      nil)))

(defn create-user [user] 
(try
  ;; check :username and :email exists,
  ;; if does not then raise exception
  (sql/insert! ds :users user)
  (catch Exception e
    (println "Error creating user:" (.getMessage e))
    nil
    )
  )
)

(defn update-user [id user]
  (def user-id (parse-id id))
  (sql/update! ds :users user {:id user-id}))

(defn update-user-status [id status]
   (def user-id (parse-id id))
  (sql/update! ds :users {:status status} ["id = ?" user-id]))

(defn delete-user [id]
  (def user-id (parse-id id))
  (sql/delete! ds :users {:id user-id}))

(defn get-user [id]
  (def user-id (parse-id id))
  (sql/get-by-id ds :users user-id)
  )

;; (defn get-user [id]
;;   (first (jdbc/execute! ds ["SELECT * FROM users WHERE id = ?" id])))

(defn get-all-users [] 
  (sql/query ds ["SELECT * FROM users"])
  )

(defn create-post [post]
  (sql/insert! ds :posts post)
  )

(defn update-post [id post]
  (sql/update! ds :posts post {:id id})
  )

(defn update-post-status [id status]
  (sql/update! ds :posts {:status status} {:id id}))

(defn delete-post [id]
  (sql/delete! ds :posts {:id id})
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
