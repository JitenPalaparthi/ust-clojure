(ns demo16.core
  (:gen-class))

(declare print_to_n)
(declare print_n_to)
(declare is_even_print)
(declare is_even)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ;; (loop [i 1]
  ;;   (when (<= i 100)

  ;;     (println i)

  ;;     (recur (inc i))))
  (def nums1 '(10 15 16 18 92 12 14 64 33 26)) ; print only even numbers from the list
  (def nums2 #{10 15 16 18 92 12 14 64 33 26}) ; print only odd numbers from the set

  (print_to_n 100)
  (println)
  (print_n_to 100)
  (println)
 ; (is_even_print 200)

  ;; (even? 100)

  ;; using map 
   (println "using map iteration")
  (doall (map (fn [n] (when (is_even n)
                 (println n))) nums1))

;; (map println (filter even? nums1))
  (println "nums1 using doseq")
  (doseq [n nums1]
    (when (= (is_even n) true)
      (print n " ")))
 (println "nums1 using for")
  (doall (for [n nums1
               :when (is_even n)]
           (println n))))
;;(map )




(defn print_to_n [n]
  (loop [i 1]
    (when (<= i n)
      (print " " i)
      (recur (inc i)))))

(defn print_n_to [n]
  (loop [i n]
    (when (>= i 1)
      (print " " i)
      (recur (dec i)))))

(defn is_even_print [num]
  (if (= (mod num 2) 0)
    (do
      (println num true)
      true) (do
              (println num false)
              false)))


(defn is_even [num]
  (if (= (mod num 2) 0)
    true
    false))
;; iterate throu the list and set and find out whether a number is even number or not