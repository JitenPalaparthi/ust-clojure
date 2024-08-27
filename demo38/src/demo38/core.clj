(ns demo38.core
  (:gen-class)
  (:require [demo38.protocols :as protocols]
            [demo38.fetchers :as fetchers]))

(defn process-data [fetcher endpoint]
  (protocols/fetch-data fetcher endpoint)
  )

(defn -main 
  [& args]
(let [api-fetcher (fetchers/map->ApiFetcher {:base-url "http://abcd.com/fetch-url"})
      file-fetcher (fetchers/map->FileFetcher {:directory "/tmp/data/files"}) 
      ]
  (println (process-data api-fetcher "/users"))
  (println (process-data file-fetcher "usersdata.txt")) 
  ) 
  )
