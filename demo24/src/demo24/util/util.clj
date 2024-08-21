(ns demo24.util.util)


(defn- greet[]
 (println "Hello World! Welcome to util service")
  )

(defn util-greet[]
  (greet)
  )

(defn util-greet-p1 [msg]
  (println msg))

(defn- util-private-greet[]
  (println "Hey I am a private function, cant be called public")
  )