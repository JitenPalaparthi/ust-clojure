(ns demo45.db
  (:require [clojure.java.jdbc :as jdbc]))

(def db_spec
  {:dbtype "postgresql"
   :dbname "appdb"
   :host "localhost"
   :port 5432
   :user "app"
   :password "app123"})

(defn create-user [username email]
  (jdbc/insert! db_spec :users {:username username :email email})
  )