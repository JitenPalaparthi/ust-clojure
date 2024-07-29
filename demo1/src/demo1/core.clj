(ns demo1.core
  (:gen-class))

(declare greet)
(declare greet2)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "Hello UST Folks")
  (greet)
  )

(defn greet 
  "this is a demo function"
  []
  (println "Hello UST Minds. Happy learning of Clojure"
           ))

;; :gen-class : can generate a java class from clojure code