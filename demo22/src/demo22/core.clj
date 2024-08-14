(ns demo22.core
  (:gen-class))
(declare reduce-with)
(declare greet)
;;(declare reduce-with2)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
  ;; (reduce f col)
  ;; (map f col) ; [ 1 2 3 4]
  

  (def r1 (reduce + [1 2 3 4 5]))

  (println "reduce:" r1)

  (def m1 (reduce max [ 12 43 12 434 3 34 34 35 6456 4 54445 45445]))

  (println "max number:" m1)
  ;; what is + here ?
  ;; what reduce is going to give ?
  
  ;; 
  
  
  (def shopping-cart [
                      {:name "Apple" :price 1.5 :quantity 4.0}
                      {:name "Banana" :price 0.5 :quantity 12.0}
                      {:name "Mango" :price 2.2 :quantity 15.0}
                      {:name "Peach" :price 4.2 :quantity 8.0}
                      ])

  (def total-cost1 (reduce (fn [acc item]  
                            (+ acc (*  (:price item) (:quantity item)))) 
                          0 shopping-cart ) 
    )
  
  
  (println "total-cost:" total-cost1) 

   (def total-cost2 (reduce reduce-with
                          0 shopping-cart))
    (println "total-cost:" total-cost2)
  
  ;; the below does not work because, with reduce you can use functions with only one or two argumnets which are col or val and col
  ;; (def total-cost3 (reduce reduce-with2
  ;;                          0 shopping-cart))
  ;; (println "total-cost:" total-cost3)

  (greet)
  (greet "UST")
  (greet "Hey" "UST")
)

;; acc: accumulator --> Current accumulated value
;; the default value is 0


(defn reduce-with [acc item]
  (+ acc (*  (:price item) (:quantity item))) 
)

;; (defn reduce-with2 [acc1 acc2 item]
;;   (+ acc1 (*  (:price item) (:quantity item)))
;;   (println acc2)
;;   )


(defn greet ([] (println "Hello World!"))
  ([msg] (println "Hello" msg))
  ([msg name] (println msg name))
  )

