(ns demo2.core
  (:gen-class))
;(declare greet)
(defn greet [msg] (
                   println msg))
(declare add)

;; all the top level variables as below are stored in data segment
(def PI 3.14) ;It is a global variable.Global for the namespaces 
(def ok false)
(def name "UST Global")
(def i 100)
(def j 10.12)
;; end of top level variables

(def ^:dynamic *dvar* 100) ;; dynamic variables are stored in heap memory


(defn -main
  "I don't do a whole lot ... yet."
  [& args] ;; a list with variable number of args is stored in heap memory
  (println "Hello, World!")
  (greet "Hello UST")
  (println (add 10 20))
  (binding [*dvar* (add 100 300)]
    (println "inside binding:" *dvar*) 
    )
  (println "out of binding scope:" *dvar*))

;; function and function parameters are stored in stack memory
(defn add [a b]
  (+ a b)) ;; the return type also stored in stack memory
