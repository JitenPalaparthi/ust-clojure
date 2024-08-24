(ns demo32.core
  (:gen-class))

(defprotocol Shape ; similar to interface or trait
  (area [this])
  (perimeter [this]))

(deftype Rectangle [length bredth]
  Shape
  (area [this]
    (* length bredth))
  (perimeter [this]
    (* 2 (+ length bredth)) ; 2 * (l+b)
    ))

(defn -main
  [& args]
  ;; (def rect (Rectangle. 10.12 13.4))
  ;; (println "Area of rect:" (area rect))

  (let [rect (Rectangle. 10.34 14.55)]
    (println "Area of rect:" (area rect))
    (println "Perimeter of rect:" (perimeter rect))
    ))
