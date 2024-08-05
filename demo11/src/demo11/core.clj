(ns demo11.core
  (:gen-class))

(declare square)
(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def list1 '(20, 30,40,50))
  (println list1)
  (def list2 '("jiten","Siddique" ,"Raj"))
  (println list2)
  (println (first list1))
  (println (last list1))
  (println (cons 100 list1))
  (def new-list1 (cons 100 list1))
  (println new-list1)
  (def new-list2 (map #(* 2 %) new-list1))
  (println new-list2)

  (def new-list3 (map square new-list1))
  (println new-list3)
)
;; [1 "stret-1" 2500 91]
;; ["street-2" 2 91 2300]

;; int n1 = 100;
;; ChanVal(n1);
;; print(n1);
;; int ChanVal(int n){
;;                    n = n *n;
;;                    return n;
;; }

(defn square [n]
  (* 2 n)
  )