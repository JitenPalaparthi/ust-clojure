(ns demo48.core
  (:gen-class))

;; this could be database, message broker, another service, http handle function or anything
;; assume that this function is an external call
(defn some-service-call []
  "real-service-response"
  )

(defn process-date []
  (let [response (some-service-call)]
    (str "processed: " response) 
    )
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args] 
  )
