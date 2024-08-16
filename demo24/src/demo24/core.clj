(ns demo24.core
  (:gen-class)
  (:require [demo24.util.util :as util])
  (:require [demo24.service :as service] )
  (:require [demo24.dir1.dir2.dir3.dir3 :as dir3]) 
  )
  

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (util/util-greet)
  (util/util-greet-p1 "Hello UST Global. Welcome tom clojure training")
  (service/greet-service)
  (dir3/greet)
  )
