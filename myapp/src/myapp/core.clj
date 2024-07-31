(ns myapp.core
  (:gen-class)
  (:import [myapp MyClass])
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (def obj1 (MyClass. 38 "Jiten" "India")) ;; constructor has two arguments to pass
  (println "Age:" (.getAge obj1))
  (println "Name:" (.getName obj1))

  (def obj2 (MyClass.)) ;; constructor has two arguments to pass  
  (.setAge obj2 40) ;; obj2.setAge(40) .setAge obj2 40
  (.setName obj2 "Jiten P")
  (println "Age:" (.getAge obj2))
  (println "Name:" (.getName obj2))
  )

