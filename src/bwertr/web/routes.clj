(ns bwertr.web.routes
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [bwertr.web.handlers :as h]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.session :refer [wrap-session]]
            [ring.middleware.session.cookie :refer [cookie-store]]))

(defroutes app-routes
  (GET "/" [] h/welcome)
  (GET "/results" [] h/results)
  (POST "/" [] h/rate)
  (route/resources "/")
  (route/not-found "<h1>Page not found.</h1>"))

(def app
  (-> app-routes
      wrap-base-url
      wrap-keyword-params
      wrap-params
      (wrap-session {:store (cookie-store {:key "JUGMSJUGMSJUGMS!"})})))
