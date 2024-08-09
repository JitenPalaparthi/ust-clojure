(ns demo17.core
  (:gen-class))
(declare process-list)
(declare is-positive)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def my-list1 `(100 200 300 nil 500))
  (println my-list1)
  (def num1 nil)
  (println (nil? num1))
  (println (some? my-list1)) ;; this returns true or false
  (println (nil? my-list1))
  (def my-list2 '()) ;; 
  (def my-list3 nil) ;;nil variable 
  (def my-set1 #{})
  (println "is nil? " (nil? my-list2) my-list2)
  (println "is there some value?" (some? my-list2))
  (println "emoty set" my-set1)
  (println "is the set nil?" (nil? my-set1))
  (println "is the set some?" (some? my-set1))

  (println (process-list my-list1)) ; list with values and one of the values is nil
  (println (process-list my-list2)) ; empty list which is not nil
  (println (process-list my-list3)) ; nil list

  ;; can concatinate and format any kind of variable to str
  (def str1 (str "the str is string formatter.It can foramt to any type of value .For instance int:" 100 " boolean:" true " float:" 123.12312 " list:" '(1,2,3) " set:" #{1,2,3}))

  (println str1 "type:" (type str1))
  ;; (println "type:" (type my-list1))
  ;; (println "type:" (type my-set1))

  (println (is-positive 10)) ;; what is the output of this?
  (println (is-positive -1)) ;; what is the output of this?
  )

;; nil : when there is no value to a variable then it can be nil
;; Default Value: A default value can be nil , even a function return type can be nil, to indicate no value is returned
;; an empty list is different than nil

;; What does this function return?
;; What datatype value it returns?
(defn process-list [lst]
  (if (nil? lst)
    "list is nil"
    (str "List is:" lst)))


(defn is-positive [n]
  (when (>= n 0)   ;; when the condition is not true, the when form returns nil
   true
  ) 

  ;; (when (number? n)
  ;;   (cond
  ;;     (pos? n)(println "positive")
  ;;     (neg? n) (println "negative")
  ;;     (zero? n)(println "zero")
  ;;     )))
)