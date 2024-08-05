(ns demo7.core
  (:gen-class))

(declare greet1)
(declare greet2)
(declare greet3)
(declare sumOf)
(declare sum1)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (greet1)
  (greet1 "Hello UST")
  (greet1 "UST","How you folks are doing")
  (greet2)
  (greet2 "Jiten")
  (greet2 "Jiten" "Raffiq")
  (greet2 "Jiten" "Raffiq" "David")

  (greet3 "Jiten")
  (greet3 "Jiten" "Raffiq")
  (greet3 "Jiten" "Raffiq" "David")

  (println (sumOf 10 20 40 50 60 70 80))
  (def sum #(+ %1 %2 %3))

  (let[s (sum 10,20,30)]
   (println s)
   )
  


  ;; (println (sumOf 10 20 40 50 60 70 80 "hello" true 123.213))

  (sum1 12 13)
  ;; (sum1 12 true)
  ;; (sum1 123.123 "Hello")
  )


;;Multi-Arity functions

(defn greet1
  ([]
   (println "Hello world!"))
  ([msg]
   (println msg))
  ([msg name]
   (println "Hello" msg name)))
;; write a multi-arity function for the below requirement
;; write a function with no argument, one argument, two and three
;; if no argument , it should return 1
;; if one argument , it should return then area of square
;; if two arguments, it should return the area of rect
;; if three arguments , it should return the area of cuboid

;; variadic arguments
;; if there is nothing like fixed number of arguments , then can use variadic 


(defn greet2
  [& names]
  (println "Hello " names))

(defn greet3 [& names ]
 ;; (str "Hello ",(clojure.string/join ", " names) "!") 
 ;; (def n (str "Hello ",(clojure.string/join ", " names) "!"))

  (let [msg (str "Hello ",(clojure.string/join ", " names) "!")]
    (println msg)
    (println "This is my special message:" msg))
  ;;(println msg) 
  )

(defn sumOf [i j & nums]
  (apply + i j nums))

(defn sum1 [i j]
  (println (+ i j)))