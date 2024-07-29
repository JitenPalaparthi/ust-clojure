(ns demo1.core
  (:gen-class))

(declare greet)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "Hello UST Folks")
  (greet)
  )

(defn greet []
  (println "Hello UST Minds. Happy learning of Clojure"))

;; :gen-class : can generate a java class from clojure code