(ns demo23.core
  (:gen-class)
(:require [clojure.java.io :as io] )  
)

(declare write-file)
(declare read-file)
(declare append-file)
(declare delete-file)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def str1 (slurp "../files/data.txt")) ;; to read a file on the disk
  (println str1)

  ;(def str2 (slurp "https://clojure.org")) ;; to read a content online using a webaddress

  ;(println str2)

  (def file-path "../files/data.txt")

  (def delete? (delete-file file-path))
  (println "Deleted:" delete?)
  
  (write-file  file-path "Hello folks, we are in Clojure session")
  
  (def str3 (read-file file-path))
  (println str3)
  
  (append-file file-path "\n This session is all about file based operations")
  
  (def str3 (read-file file-path))
  (println str3)

  
  (def file-path "../files/data1.txt")
  
  (def delete? (delete-file file-path))
  (println "Deleted:" delete?)
  
  )

;; Execution error (FileNotFoundException) at java.io.FileInputStream/open0 (FileInputStream.java:-2).
;; files/data.txt (No such file or directory)

;; 100 operations per min 
;; if you use file base approach, 
;; everytime the file is read, updated, written or apended
;; io operations, file io or network io


(defn write-file [file-path content]
  ;;(spit "../files/data.txt" "Hello folks, we are in Clojure session")
  (spit file-path content))

;; this reads the file and written as a string
(defn read-file [file-path]
(slurp file-path)
  ) 

(defn append-file [file-path content]
  (spit file-path content :append true)
  )

(defn delete-file [file-path]
(let [file (io/file file-path)]
  ;; file.exists
  (when (.exists file)
    (.delete file)
  ) 
  ) 
  )

;; have a look at the delete-file function
;; when the file is not existed , return false ,currently it is returning nil due to when block
