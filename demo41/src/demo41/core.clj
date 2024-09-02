(ns demo41.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.util.response :refer [response]]
   [ring.middleware.params :refer [wrap-params]]
   [cheshire.core :as json]))

(defn handler-1 [request]
  (def data {:message "Hello, UST Global minds!"})
  (response (json/generate-string data)))

(defn handler-2 [request]
  (let [name (get-in request [:params :name] "Guest")
        data {:greeting (str "Hello," name)
              :status "success"}]
    (response (json/generate-string data))))

(defn -main
  [& args]
  (run-jetty (fn [request]
               (case (:uri request)
                 "/hello" (handler-1 request)
                 "/greet" (handler-2 request)
                 (response (json/generate-string {:error "route not found"})))) {:port 8081 :join? false}))
