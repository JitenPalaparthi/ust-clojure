(ns demo3.core
  (:gen-class))

(defn add [a b]
  (println "Addition:", (+ a,b)))
(def v1 100)
(defn sum []
  (println v1))
(def my-state (atom 10))

(def name "UST") ;; global variable

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  ;;(def name "UST")
  ;; (def str "UST" "Global") 
  (def abcd (str "UST"," Global" " " 1.0 " " true " " 1.45 " " 3234234 " " 0.5))
  (println abcd)
  (println (add 12,13))
  (println (add 12 13))

  (def v1 (+ 3,100,34))
  (def v2 (* v1 (+ 4 5)))
  (def v3 (float (/ v2 7)))
  (println v3)
  (def v4 (float (/ (* (+ 3,100,34) (+ 4,5)) 7)))
  (println v4)
  (let [x 10
        y 20
        sum (+ x y)]
    (println "Sum of x and y:" sum))

  (println @my-state)
  (swap! my-state inc)
  (println @my-state)
  (swap! my-state #(+ % 2))
  (println @my-state)
  ;;(swap! my-state (inc 1)
  ;; i+ = 1
  ;; i++
  ;; i = i+1

  (def sub #(- %1 %2)) ;; 

  (println (sub 12 15))

  ;; var f1 = func(a,b int)int{
  ;;              return a+b          
  ;; }

  ;; f1(10,20)
  
  )


;; ((3 + 100 + 34) * (4+5)) / 7 ;; The preceded is not a clojure expression but write it in clojure way
;; store the result in a variable , the result should be in float 

;; (3.14 * 12) + (32 * 32.4)/12 - 32.23+47/2
;; concatinate result into str1 in the string format
;; print the value 