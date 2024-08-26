(ns demo37.core
  (:gen-class))

(defprotocol PersonProtocol
  (get-name [this])
  (get-age [this])
;;  (set-name [this new-name])
  )

;; (defrecord Person [^:voltile-mutable name age]
(defrecord Person [name age]
  ;; PersonProtocol
  ;;  (get-name [this]
  ;;           (:name this))
  ;; (get-age [this]
  ;;          (:age this))
  )

(extend-type Person
  PersonProtocol
  (get-name [this]
    (:name this))
  (get-age [this]
    (:age this))
  ;; (set-name [this new-name]
  ;;   (set! (.name this) new-name))
    )

(defn -main
  [& args]

  (def p1 (->Person "Jiten" 39))
  (def p2 (->Person "Sadique" 34))
  (println "p1 details")
  (println "Name:" (get-name p1))
  (println "Age:" (get-age p1))
  (println "p2-details")
  (println "Name:" (get-name p2))
  (println "Age:" (get-age p2))
 ;; (set-name p2 "Sk")
  ;;(println "Name:" (get-name p2)))
)