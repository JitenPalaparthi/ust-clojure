(ns demo34.core
  (:gen-class))
(defprotocol  Shape
  (area [this])
  (perimeter [this])
 )

(deftype Square [side]
  Shape
  (area [this]
    (* side side))
   (perimeter [this]
        (* 4 side)) 
  
  Object
  (toString [this]
    (str "Square side=" side)
    )
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def s1 (Square. 25.25))

  (println "Area of square:" (.area s1)) 
  (println "Perimeter of square:" (.perimeter s1))
  (println (.toString s1))

  )
