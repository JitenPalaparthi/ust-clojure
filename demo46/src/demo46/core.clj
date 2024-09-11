(ns demo46.core
  (:gen-class)
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [clojure.tools.logging :as log])
  )

(def db-spec {
              :dbtype "postgresql"
              :dbname "appdb"
              :host "localhost"
              :port 5432
              :user "app"
              :password "app123"
})

(def datasource (jdbc/get-datasource db-spec)) ;; connection pooling 

(defn insert-user [username email] 
  (log/info "inserting user data into users table.username:" username "email:" email) 
  ( def result (sql/insert! datasource :users {:username "Siddiuq" :email "siddique@gmail.com"} {:return-keys true}))
  (:id result)
  )
(defn -main 
  [& args]
  (def result (insert-user "rajesh" "rajesh@gmail.com"))
 (println "inserted:" result)
  
   (def result1 (jdbc/execute-one! datasource ["INSERT INTO users (username, email) VALUES (?, ?) RETURNING id" "amala" "amala#outlook.com"]))
  (println result1)
  (println "inserted execute-one:" (type result1))
  (println "inserted execute-one:" ( :users result1))
  (println (first result1))
  (println (:users/id result1))
  )
