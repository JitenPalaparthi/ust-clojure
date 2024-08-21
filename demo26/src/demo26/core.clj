(ns demo26.core
  (:gen-class))
(def counter (ref 0)) ;; global variable 
(declare increment-counter)
(declare get-value)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (increment-counter)
  (increment-counter)
  (increment-counter)

  (println "counter:" (get-value)))
(defn increment-counter []
  (dosync
   (alter counter inc)))

(defn get-value []
  ;;(deref counter)
  @counter)
;; how do you alter a value for an atom? 

;; what is atomic operation?
;; does mutex ensure atomic operation?
;; is ref in clojure an atomic operation?
;; STM
;; why dosync ?

;; create a ref variable of a vector 
;; create a function to double the vector
;; get the vector after calling the function