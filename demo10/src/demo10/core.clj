(ns demo10.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def num1 22)
  (when (and (> num1 20) (= (rem num1 2) 0))
    (println num1)
    (println "square of num:" (* num1 num1))
    (println "slash the number by 2" (/ num1 2)))

  (when (and (> num1 20) (even? num1))
    (println num1)
    (println "square of num:" (* num1 num1))
    (println "slash the number by 2" (/ num1 2)))


  ;; simple case 

  (def day 3)

  (case day
    1 (println "Monday")
    2 (println "Tuesday")
    3 (println "Wednesday")
    4 (println "Thursday")
    5 (println "Friday")
    6 (println "Saturday")
    7 (println "Sunday"
               println "Sunday is a holiday"
               println "I have lot of work on sunday")
    (println "no day"))

  (def num1 12)
  (cond
    (= (rem num1 2) 0) (
                        println num1 "is divisible by 2"
                        (when (= (rem num1 3) 0) 
                          (println num1 "is divisible by 3"))
                        )
    (= (rem num1 3) 0) (println num1 "is divisible by 3")
    (= (rem num1 5) 0) (println num1 "is divisible by 5")
    :else (println num1 "is not divisible by 2 ,3 and 5")))

