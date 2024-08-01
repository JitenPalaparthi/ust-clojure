(ns demo6.core
  (:gen-class))

(declare MajorOrMinor)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!") 
  
;;   (def age 18)
;; (if (>= age 18)
;;  (println "according to age he or she is major")
;;  (println "according to age he or she is minor") 
;;  )
  
  (MajorOrMinor 39)
  (MajorOrMinor 17)
  )

(defn MajorOrMinor [age]
  (if (>= age 18)
    (do
    (println "Age is " age)
    (println "according to age he or she is major"))
  (do
    (println "Age is " age)
    (println "according to age he or she is minor"))) 
)

