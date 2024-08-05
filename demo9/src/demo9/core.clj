(ns demo9.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
  (def age 20)
  (def gender "male")
  (
   if (and (>= age 18) (= gender "female"))
    (println "she eligible for marriage") 
    (if (and (>= age 21) (= gender "male"))
      (println " he eligible for marriage") 
      (println "not eligible for marriage")
      )
  )
)
