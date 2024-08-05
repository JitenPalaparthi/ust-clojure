(ns demo13.core
  (:gen-class))
(declare double-element)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def matrix '((1 2 3) (4 5 6) (7 8 9)))

  (println matrix)
  (def double-matrix (map (fn [row] (map double-element row)) matrix))
  (println double-matrix)
  
  ;;(def double-matrix2 (map #(%) matrix))
  
  
  )
  

(defn double-element [x]
  (* 2 x))
