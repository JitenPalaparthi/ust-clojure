(ns demo19.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def my-map1 (hash-map :100 "Jiten" :101 "Raffiq" :102 "Nisha" :103 "Siddiq"))

  (println my-map1)

  (println "Name:" (get my-map1 :101))

  (def my-map1 (assoc my-map1 :101 "Mohammed Raffiq")) ;; we are updating the map and assiging back with the same map varialbe name
  (def my-map1 (assoc my-map1 :100 "Jiten Palaparthi"))
  (println my-map1)

  (def my-map1 (dissoc my-map1 :100)) ; to remove/delete from map
  (println my-map1)

  (def my-map1 (assoc my-map1 :104 "Sebastian Paul")) ;; to add a new entry to the map

  (println my-map1)


  (def my-map2 (hash-map :105 "Shreya" :106 "Ashish" :107 "Obul Reddy"))
  (def my-map3 (hash-map :108 "Sarath" :109 "Sripad" :110 "Kriti"))


  (def my-map1 (merge my-map1 my-map2 my-map3 {:100 "Jiten Palaparthi"})) ; to merge maps 

  (println "after merge:" my-map1)

  ;; iterate
  ;; not in order.
  (println "Iterate a map")
  (doseq [[key value] my-map1]
    (println "Key:" key "Value:" value))
  
  (def keys-my-map1 (keys my-map1))
  
  (println keys-my-map1)
  (println (type keys-my-map1))
  
   (def values-my-map1 (vals my-map1))
  
  (println values-my-map1)
  (println (type values-my-map1))

  ;; add all the keys to a vector , set and list

  (def vec-keys-my-map1 (vec (keys my-map1)))
  (def set-keys-my-map1 (set (keys my-map1))) 
  (def list-keys-my-map1 (list (keys my-map1)))

  
  (println "Type of keys" (type vec-keys-my-map1) "Value of keys:" vec-keys-my-map1) 
  (println "Type of keys" (type set-keys-my-map1) "Value of keys:" set-keys-my-map1) 
  (println "Type of keys" (type list-keys-my-map1) "Value of keys:" list-keys-my-map1)


  )

;; constant time O(1)
;; logarthmic time O(log n)
;; there are many 



;; How does map work?
;; 