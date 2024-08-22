(ns demo28.core
  (:gen-class))
(declare add)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def f1 (future (Thread/sleep 500)
                  (* 200 200)))
  (def a1 (future (Thread/sleep 500)
                  (add 10 20)
                  ))
  
  (println "doing some work. I will get  value from above future")
  (println "Future add a1:" @a1)
  (println "Future value f1:" @f1) ;; main thread is blocked until it fetches a value from a future
;; in order to use a future use future form
;; what future does? future yields the result in the future 
;; result is yielded to f1 becase f1 is a placeholder
)
(defn add [a b]
  (+ a b))