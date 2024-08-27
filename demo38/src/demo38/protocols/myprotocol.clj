(ns demo38.protocols.myprotocol)

(defprotocol DataFetcher
  (fetch-data [this end-point]))