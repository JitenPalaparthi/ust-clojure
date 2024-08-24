(ns demo33.core
  (:gen-class))

(deftype Rectangle [l b])

(defn create-rect [l b] ;; similar to constructor
  (Rectangle. l b)
  )

(defn area [rect]
  (* (.l rect) (.b rect))
  )

(defn perimeter [rect]
  (*  2 (+ (.l rect) (.b rect))))

(defn -main 
  [& args]
  (def r1 (Rectangle. 10 20))
  (def a1 (area r1)) 
  (def p1 (perimeter r1))
  (println "Area of r1:" a1)
  (println "Perimeter of r1:" p1)

  (def r2 (create-rect 10 20))
  (println "type of r2:" (type r2))
  )
