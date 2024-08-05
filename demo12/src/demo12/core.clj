(ns demo12.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def list1 '(10,20,30,40,50))

  (println list1)

  (doseq [e list1]
    (println e))

  (def sum (atom 0))

  (doseq [e list1]
    (swap! sum + e))
  
  (println "Sum of list1:" @sum)

  (def double-list1 (for [e list1]
                      (* 2 e)))
  
  (println double-list1)

  (def sumof (reduce + double-list1))
(println "sum of:" sumof)
  )
;; findout the difference between map and reduce