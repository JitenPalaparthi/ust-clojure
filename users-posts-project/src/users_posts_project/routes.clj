(ns users-posts-project.routes
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE]] 
            [users-posts-project.db :as db]
            [cheshire.core :as cheshire]
           ; [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response]]))

;; (defn parse-json [body]
;;   (cheshire/parse-string body true)
;;   )

;; (defn generate-json [data]
;;   (response/content-type (response/response (cheshire/generate-string data)) "application/json"))


;; (defroutes app-routes
;;   (POST "/users" req
;;     (
;;     ;;  let [user (:body req)]
;;     let [body (slurp (:body req))
;;          user (parse-json body)]
;;       ;; check email validation whether email is valid or not
;;       ;; (println (:username user))
;;       ;; (println (type user))
;;       (if (and (:username user) (:email user)) 
;;         ;; (response/response (db/create-user user))
;;         (generate-json (db/create-user user))
;;         (-> (response/bad-request "missing required field either username or email") 
;;             (generate-json))))) 
;;     )

;; (defroutes app-routes
;;   (POST "/users" req
;;     (let [user (:body req)]
;;       ;; check email validation whether email is valid or not
;;       (if (and (:username user) (:email user)) 
;;         (response/response (db/create-user user))
;;         (response/bad-request "missing reauired field either username or email")))))


(defn json-response [data]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (cheshire/generate-string data)})

(defroutes user-routes
  (GET "/users" [] (json-response (db/get-all-users)))
  (GET "/users/:id" [id]  (json-response (db/get-user (Integer. id))))
  (POST "/users" req 
    ;; (
    ;;                   (println "xxxxxx--->" req) 
    ;;                   json-response (db/create-user (:body-params req)))))
    (let [user-map (:body-params req)]
        (if (and (:username user-map) (:email user-map))
          (response {:message "User created successfully" :user user-map})
          (response {:error "Invalid user data"})))))

;; (defroutes post-routes

;; )