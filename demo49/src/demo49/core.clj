(ns demo49.core
  (:gen-class))

(defmacro lets-print [fn-name & args]
  `(do
    (println "Executing function " '~fn-name "with arguments" ~@args (~fn-name ~@args)) 
    )
  )


(defmacro simple-macro []
  (println "hello , thisn is a simple macro")
  )

; it treats the following form as a code
; ~ ~@ includes the values

(defn add [a b ]
  (+ a b)
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (lets-print add 10 20) 
  (simple-macro)
  )
