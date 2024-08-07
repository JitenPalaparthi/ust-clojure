(ns demo15.core
  (:gen-class))

(declare sumof-set)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
  (def myset #{3,4,5,6,7,1,2})
  (def sum (sumof-set myset))

  (println "sum fo myset:" sum)
  (def r1 (rest myset))
  (println myset)
  (println r1)
  (def r2 (rest r1))
  (println r2)
  )
(defn sumof-set [s]
  (loop [r (seq s) sum 0]
    (if (empty? r)
      sum
    ;; else
      (recur (rest r) (+ sum (first r)))))

; 1 2 3 4 5 6 7  --> 1
  ; 2 3 4 5 6 7  --> 2
  ; 3 4 5 6 7    --> 3
  ; 4 5 6 7      --> 4
  ; 5 6 7        --> 5
  ; 6 7          --> 6
  ; 7            --> 7
  )