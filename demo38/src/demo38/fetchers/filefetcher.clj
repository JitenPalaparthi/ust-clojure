(ns demo38.fetchers.filefetcher
   (:require [demo38.protocols.myprotocol :as protocols])
  )

(defrecord FileFetcher [directory]
  protocols/DataFetcher
  (fetch-data [this end-point]
    (str "Fetching data from directory:" directory end-point)))