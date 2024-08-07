(ns demo14.core
  (:gen-class))

(declare sumof-set)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]


  (def myset #{1,3,4,5,6,7,2})

  (println myset)

  (def myset1 (sorted-set 1 3 4 5 2 8 7 6))
  (println myset1)

  ;;(def myset3 (sorted-set myset))
  (def myset2 (apply sorted-set myset))

  (println myset2)

  (def myset3 (conj myset 17 18 16 19 9 21 14))
    (println myset3)

  ; set is unordered. So there is no guarante that the same element is fetched everytime you call the nth element

  (def myset-seq (seq myset))
  (def nthelement2 (nth myset-seq 4))

  (println "4th element from myset:" nthelement2)

  (def sumof (reduce + myset))

  (println "Sum of element myset" sumof)

  (println "Sum of elements from the set " (sumof-set myset))
  ;; (def nth-myset (nth myset 3))
  ;; (println "3rd element from myset:" nth-myset)


  )
;; set does not accept duplicate elements

;; pick the nth element from a set 
;; get the sum of elements from a set 
;; print the list of elements in a set in dec order
;; 

