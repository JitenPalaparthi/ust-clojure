(ns demo25.core
  (:gen-class))
(declare long-task)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (def my-future (future (long-task)))

  ;; Do other work while the task runs
(println "Doing other work...")

;; Retrieve the result of the future (this will block if the task isn't complete yet)
(def result @my-future)

;; Print the result
(println "The result is:" result)
  
  )

(defn long-task []
  (Thread/sleep 3000) ; Simulates a delay of 3 seconds
  (println "Task completed!")
  42) ; The result of the task
