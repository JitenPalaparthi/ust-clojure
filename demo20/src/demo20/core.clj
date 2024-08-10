(ns demo20.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ; there are two ways to create a map 1. using {} and 2. using hash-map function
  (def my-map1 {:100 "Jiten" :101 "Shreaya" :102 "Nisha"})
  ;(def my-map2 (hash-map :100 "Jiten" :101 "Shreaya" :102 "Nisha"))
  
  (def keys-my-map1 (keys my-map1))

  (println keys-my-map1)

  (def my-map2 {})
 (def my-map3 nil) ; if nil is given this may not be even map becase the value is nil
 (println "Is Map Empty " (empty? my-map2))
 (println "Is Map nil " (nil? my-map3))
  )
