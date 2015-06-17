(ns bwertr.web.handlers
  (:require [bwertr.web.views :as v]
            [bwertr.model.ratings :as ratings]))

(defn welcome [request]
  (if-let [own-rating (-> request :session :own-rating)] 
    (v/thank-you own-rating (ratings/average))
    (v/welcome)))

(defn results [request]
  (v/results (ratings/average)))

(defn rate [request]
  (let [params (:params request)
        rating-param (:rating params)
        rating (Integer/valueOf rating-param)
        session (:session request)]
    (ratings/add! rating)
    {:status 200,
     :headers {"Content-Type" "text/html"}
     :body (v/thank-you rating (ratings/average))
     :session (assoc session :own-rating rating)}))
