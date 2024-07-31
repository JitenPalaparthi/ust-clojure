(ns demo4.core
  (:gen-class)
  (:import [java.lang Math String])
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (Math/sqrt 25)) ;; calling a method from a single ton class Math
  (println (Math/sin 45))

  (def str1 "Hello UST, using str1")
  (println str1)
  (def str2 (String. "Hello UST, using String"))
 (println str2)
  (def str3 (new String  "Hello UST, using new String")) ;; String str3 = new String("Hello UST, using new String")
  (println str3)

  (println "length of str2:" (.length str2)) ;; str2.length 
  (println "length of str2:" (.length str3)) ;; str3.length

  )
