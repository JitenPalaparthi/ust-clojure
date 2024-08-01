(ns demo5.core
  (:gen-class))
(declare countdown)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (def i (atom 1)) ;; why?
  (while (<= @i 10) ;; wile why @i
    ;;(do ;; why do
      (println @i) ;; why @
      (println (* @i @i))
      (swap! i inc) ;; why swap and inc
      )

  ;; instead of atom write a while loop using let or binding ^:dynamic
  ;; reverse print from 10 - 1 
  ;; 
  (println "using loop binding")
  (countdown 10)
  (println)
  (println "loop directly")
  
  (loop [i 5] (when (> i 0)
                (print " " i)
                (print " " (* i i))
                (recur (dec i)))))



(defn countdown [number]
  (loop [n number] (when (> n 0)
                     (print " " n)
                     (recur (dec n)))))

