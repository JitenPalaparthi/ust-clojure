(ns demo45.core
  (:gen-class)
  (:require [demo45.db :as crud])
  )

(defn -main 
  [& args] 
  (crud/create-user "jiten" "jitenp@outlook.com")
  )
