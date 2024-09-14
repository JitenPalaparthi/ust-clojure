(ns users-posts-project.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   ;[ring.middleware.json :refer [wrap-json-body wrap-json-response]]
   [users-posts-project.routes :refer [user-routes]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [compojure.core :refer [routes]]
   [ring.middleware.json :refer [wrap-json-body wrap-json-response]]))

;; (defroutes app-routes
;;   (POST "/users" req
;;     (let [user (:body req)]
;;       ;; check email validation whether email is valid or not
;;       (if (and (:username user) (:email user)) 
;;         (response/response (db/create-user user))
;;         (response/bad-request "missing reauired field either username or email")))))

;; (defn start-server [] 
;;   (run-jetty (wrap-json-body (wrap-json-response app-routes {:keywords true})) {:port 3000 :join? false})
;;   )

;; (def start-server (wrap-defaults (routes  user-routes) (wrap-json-body)          ;; Parses incoming JSON requests into Clojure maps
;;       (wrap-json-response)      ;; Converts responses to JSON
;;       (wrap-defaults site-defaults)))

(def start-server
  (->
   (wrap-json-body {:keywords? true})           ;; Parses incoming JSON requests into Clojure maps
   (routes user-routes)
   (wrap-json-response)      ;; Converts responses to JSON
  ;;  (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))
   
   ))
;; (defn start-server []
;;   (run-jetty app-routes {:port 3000 :join false})
;;   )

(defn -main
  [& args]
  ;;(start-server)

  (run-jetty start-server {:port 3000 :join? false}))
