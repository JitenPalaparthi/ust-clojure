(ns demo31.core
  (:gen-class))


(defn create-vector []
  (Thread/sleep 2000)
  [1,2,3,4])

(defn double-vector [vec]
  (mapv #(* 2 %) vec)
  )

(defn -main
  [& args]
  
  (let [vector-promise (promise)] 
    (future 
      (let [vec (create-vector)]
        (deliver vector-promise vec)
        
        ) 
      ) 
    (future
    (let [original-vec @vector-promise
          double-vec (double-vector original-vec)
          ]
      (println "original vector:" original-vec)
      (println "double-vector:" double-vec)
      ) 
    ) )
  )
