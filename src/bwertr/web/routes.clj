(ns bwertr.web.routes)

(defn app [request]
  {:status 200,
   :headers {"Content-Type" "text/html"},
   :body "The presentation has not yet started."})
