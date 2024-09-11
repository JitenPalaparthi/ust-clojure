(ns demo45.core
  (:gen-class)
  (:require [demo45.db :as crud])
  )

(defn -main 
  [& args] 
  (crud/create-user "jiten" "jitenp@outlook.com")
  (println (crud/get-user-by-id 1))
  (println "Number of records deleted:" (crud/delete-user 2))
  (println "Number of records updated:" (crud/update-user 1 {:email "jiten.palaparthi@gmail.com"}))
  (println "All users")

  (println (crud/get-users))
  )
