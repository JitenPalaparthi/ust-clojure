(ns demo38.fetchers
  (:require [demo38.protocols :as protocols])
  )


(defrecord ApiFetcher [base-url]
  protocols/DataFetcher
  (fetch-data [this end-point]
    (str "Fetching data from Api:" base-url end-point)))

(defrecord FileFetcher [directory]
  protocols/DataFetcher
  (fetch-data [this end-point]
    (str "Fetching data from directory:" directory end-point)))