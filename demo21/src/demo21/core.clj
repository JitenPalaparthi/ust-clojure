(ns demo21.core
  (:gen-class))
(declare print-cube)
(declare is_even)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ;; (reduce f col)
  ;; (map f col)
  
  ;; (println "vector:" (map #(* % %) [1 2 3 4 5]))
  ;; (map #(+ %1) '(1 2 3 4)) 
  ;; (map #(+ %1) #{1 2 3 4})
  ;; (def v1 (map #(* % %
  ;;                  (def v2 (* % %))
  ;;                  (println "Argument:" v2)
  ;;                  ) [1 2 3 4 5]))
  
   (doall (map (fn [x]
                 (println "X:" x)
                 (def cube (print-cube x))
                 (println "Cube inside map:" cube)
                 (def v2 (* x x))
                 (println "squre:" v2)
                 v2
                 ) [1 2 3 4]))

  ;;(println v1)
  ;; 1 * 1 2 * 2 

(println "lazy stuff")
  
  (def v1 (map (fn [n] (when (is_even n)
                        (println n)
                         n
                         )) [1 2 3 4 5 6])
  )
  ;; (println v1)
   )

(defn print-cube [x]
  (println "cube in print-cube:" (* x x x))
  (* x x x)
  )

(defn is_even [num]
  (if (= (mod num 2) 0)
    true
    false))