(ns demo45.db
  (:require [clojure.java.jdbc :as jdbc])
  ;(:import [com.zaxxer.hikari HikariConfig HikariDataSource])
   (:import [com.mchange.v2.c3p0 ComboPooledDataSource])
  )
(Class/forName "org.postgresql.Driver")
;; Connection pool configuration
;; (defn hikari-datasource []
;;   (let [config (doto (HikariConfig.)
;;                  (.setJdbcUrl "jdbc:postgresql://localhost:5432/appdb")
;;                  (.setUsername "app")
;;                  (.setPassword "app123")
;;                  (.setMaximumPoolSize 10)
;;                  (.setConnectionTimeout 30000) ;; Timeout before connection fails
;;                  (.setIdleTimeout 600000) ;; How long a connection can be idle
;;                  (.setMaxLifetime 1800000))] ;; Max time a connection can stay open
;;     (HikariDataSource. config)))

;; (def db_spec
;;   {:dbtype "postgresql"
;;    :dbname "appdb"
;;    :host "localhost"
;;    :port 5432
;;    :user "app"
;;    :password "app123"})



;(def db_spec (hikari-datasource))
;; Function to create a c3p0 datasource
(defn c3p0-datasource []
  (let [ds (ComboPooledDataSource.)]
    (.setDriverClass ds "org.postgresql.Driver") ;; PostgreSQL JDBC driver
    (.setJdbcUrl ds "jdbc:postgresql://localhost:5432/sppdb") ;; Database URL
    (.setUser ds "app") ;; Database username
    (.setPassword ds "app123") ;; Database password
    (.setMinPoolSize ds 5) ;; Minimum pool size
    (.setMaxPoolSize ds 20) ;; Maximum pool size
    (.setAcquireIncrement ds 5) ;; Number of connections to acquire when pool is exhausted
    (.setIdleConnectionTestPeriod ds 300) ;; How often to test idle connections (in seconds)
    ds))

;; Create the connection pool and set as the db-spec
(def db_spec (c3p0-datasource))

(defn create-user [username email]
  (jdbc/insert! db_spec :users {:username username :email email})
  )
(defn get-user-by-id [id]
  (jdbc/query db_spec ["SELECT * FROM users where id = ?" id]))

(defn get-users [] 
  (jdbc/query db_spec ["SELECT * FROM users"])
  )

(defn update-user [id update-fields]
  (jdbc/update! db_spec :users update-fields ["id = ?" id])
  )
(defn delete-user [id]
  (jdbc/delete! db_spec :users ["id = ?" id]))