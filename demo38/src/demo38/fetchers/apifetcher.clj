(ns demo38.fetchers.apifetcher 
  (:require [demo38.protocols.myprotocol :as protocols])
  )

(defrecord ApiFetcher [base-url]
  protocols/DataFetcher
  (fetch-data [this end-point]
    (str "Fetching data from Api:" base-url end-point)))