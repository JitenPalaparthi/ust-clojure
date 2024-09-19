(ns demo47.core
  (:gen-class))

(defn add [a b]
  (+ a b))

(defn -main
  "I don't do a whole lot ... yet."
  [& args] 

  (println "add:" (add 10 20))
   (println "add:" (add -10 20))
  )

