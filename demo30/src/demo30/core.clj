(ns demo30.core
  (:gen-class))

(def my-promise (promise))

(defn -main
  [& args]

  (future (Thread/sleep 3000)
          (deliver my-promise "Hello, I am delivering a promise"))

  (future (Thread/sleep 1000)
          (println "Hello this is another future")
          (println "Getting value from another future" @my-promise))

  (println "will I receive the promise from main---???")
  (println "Value from the promise" @my-promise))
