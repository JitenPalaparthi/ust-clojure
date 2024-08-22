(ns demo27.core
  (:gen-class))
(declare some-task)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (let [thread1 (Thread. #(some-task "A"))
        thread2 (Thread. #(some-task "B"))]
    (.start thread1)
    (.start thread2)
    (.join thread1)
    (.join thread2)
    (println "Both the threads are called..")
    ))

(defn some-task [name]
  (dotimes [i 5]
    (println (str "Thread" name ":" i))
    (Thread/sleep 1000))) ;; Thread.sleep(1000)

;; (defn get-square [num] 
;;   (* num num) ; return num * num
;;   )