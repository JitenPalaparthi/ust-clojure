(ns demo36.core
  (:gen-class))

(defprotocol PCount
  (increment [this])
  (getCount [this])
 )
;;(deftype Counter [^:unsynchronized-mutable ^long count] 
(deftype Counter [^:volatile-mutable ^long count] 
  PCount
  (increment [this]
    (set! count (inc count))) 
  (getCount [this]
    count)
  )

(defn -main 
  [& args] 
  (def my-counter (Counter. 0))
  (.increment my-counter)
  (println "Counter count:" (.getCount my-counter))
  )


;; (let [a 100 b 200 c (+ a b)])