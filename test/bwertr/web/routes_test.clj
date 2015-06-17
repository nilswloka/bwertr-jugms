(ns bwertr.web.routes-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request]]
            [bwertr.web.routes :as routes]))

(deftest welcome-page-shows-greeting
  (let [request (request :get "/")
        response (routes/app request)
        response-body (:body response)]
    (is (.contains response-body "Welcome to Münster"))))
