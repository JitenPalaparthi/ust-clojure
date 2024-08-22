(ns demo29.core
  (:gen-class))
(def counter (ref 0))
(declare increment)
(declare decrement)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def f2 (future (dotimes [ i 10](decrement)))) 
  (def f1 (future (increment)))
  
  (Thread/sleep 100) 
  (println "counter:" @counter)
  )

(defn increment []
(dosync 
 (alter counter inc)
 )  
)
(defn decrement []
  (dosync
   (alter counter dec)))


