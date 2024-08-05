(ns demo8.core
  (:gen-class))

(declare sum)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")

  (#(println "Hello anonymous function"))
  (def sum1 (#(+ %1 %2) 10 20)) ;; what is this function doing ?
  ;; is it returning a value 
  ;; is it getting executed. Why 
  ;; if not how to execute
  ;; what are  those %1 and %2
  (println "sum of:" sum1)

  (def sum2 #(+ %1 %2))
  (println "sum2:" (sum2 10 20))

  (def sum3 (fn [i j] (+ i j)))
  (println "sum3:" (sum3 10 20))

  (def sum4 ((fn [i j] (+ i j)) 10 20)) 
  (println "sum4:" sum4)

  (println (type sum1))
  (println (type sum2)) 
  (println (type sum3)) 
  (println (type sum))
  
  )

(defn sum[ i j]
  (+ i j)
  )

;; what is an anonymous function? 
;; var f1 func(int,int)int // go function as a variable
;; 