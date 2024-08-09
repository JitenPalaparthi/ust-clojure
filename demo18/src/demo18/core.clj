(ns demo18.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
    ;; vector in clojure
  ;; (def my-vector1 [1 1250 35600])
  ;; (def my-vector2 [2 1300 36000])
  ;; (println (my-vector1 2))
  ;; (println (nth my-vector2 3))

  (def list1 '( 1 2 3))
  (def set1 #{1 2 3})
  (def vec1 [1 2 3])
  (def map1 {:index 1 :value 2})

  (def vec1 (conj vec1 4)) ;; very imp syntx to note, the reason is vec1 is a new vector 
  (println "type:" (type vec1))
  (println "vec1:" vec1)
  (def vec1 (assoc vec1 1 100)) ; update an element of a vector
  (println "type:" (type vec1))
  (println "vec1:" vec1)
  
  (def matrix [
               [1 1250 3500]
               [2 1400 3600]
               [3 1100 3400]
               [4 1200 3800]
  ])
  ;; nested loops are used to fetch each and every element from a multidimensional array
  (doseq [row matrix]
  (doseq [element row]
    (println element)
    ) 
  ) 

;;   (def vec2 (mapcat identity matrix))

;;   (def sum-of-vec2 (reduce + vec2))


(def sum-of-vec2 (reduce + (mapcat identity matrix)))
  
  ;; (def vec2 (mapcat identity matrix))
   ;;(println "mapcat?:" vec2)
  (println "sum of elements:" sum-of-vec2)

  (def sum-of-vec2 (reduce + [1 34 56 78  34 34 34 34 34 ])) 
  
  (println "sum of elements:" sum-of-vec2)

  (def sum-of-vec2 (reduce + (map #(reduce + %) matrix)))
    (println "sum of elements:" sum-of-vec2)
  )
; {}

;; take a 2d vector and get the sum of elements in 2d vector using a function
;; use with atom and without atom as well

;; reduce
;; map
;; apply 
;; conj
;; assoc
