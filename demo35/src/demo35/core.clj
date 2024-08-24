(ns demo35.core
  (:gen-class))

(defprotocol Area
  (area [this]))

(defprotocol Perimeter
  (perimeter [this]))

(deftype Rectangle [l b]
  Area
  (area [this]
    (* l b))
    Object
  (toString [this]
            (str "Length:" (.l this) " Bredth:" (.b this)))
  )

(extend-type Rectangle
  Perimeter
  (perimeter [this]
    (* 2 (+ (.l this) (.b this))))
  )

(defn -main
  [& args]
  (def rec (Rectangle. 10 12.45))
  (println "area of rect:" (area rec))
  (println "perimeter of rect:" (perimeter rec))
  (println "To String:" (.toString rec))
  )
