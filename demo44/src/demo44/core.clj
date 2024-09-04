(ns demo44.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            ;; [ring.util.response :as response]
            ))


;; (defn wrap-add-custom-header [handler]
;;   (fn [request]
;;     (let [resp (handler request)]
;;       (response/header resp "X-Custom-header" "UST-Global"))
;;     (handler request)
;;    ) 
;; )

;; (defn hello-world-handler []
;;   (response/response (str "Hello, World!")))

(defn -main
  [& args]
  (defroutes app-routes ((GET "/example" [] "Hello World!")
                         (route/not-found "Not Found")))
  ;(def app (wrap-add-custom-header app-routes))
  (run-jetty app-routes {:port 50001 :join? false}))