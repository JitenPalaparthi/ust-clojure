(ns demo38.protocols)

(defprotocol DataFetcher
  (fetch-data [this end-point])
 )