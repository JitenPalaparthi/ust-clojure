(ns demo38.core
  (:gen-class)
  (:require [demo38.protocols.myprotocol :as protocols]
            [demo38.fetchers.apifetcher :as apifetcher]
            [demo38.fetchers.filefetcher :as filefetcher]
            ))

(defn process-data [fetcher endpoint]
  (protocols/fetch-data fetcher endpoint)
  )

(defn -main 
  [& args]
(let [api-fetcher (apifetcher/map->ApiFetcher {:base-url "http://abcd.com/fetch-url"})
      file-fetcher (filefetcher/map->FileFetcher {:directory "/tmp/data/files"}) 
      ]
  (println (process-data api-fetcher "/users"))
  (println (process-data file-fetcher "usersdata.txt")) 
  ) 
  )
