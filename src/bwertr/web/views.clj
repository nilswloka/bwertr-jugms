(ns bwertr.web.views
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.element :refer [link-to unordered-list]]
            [hiccup.form :refer [form-to label select-options submit-button]]))

(defn page [title & content]
  (html5
   [:head
    [:title "bwertr - " title]
    (include-css "css/bwertr.css")]
   [:body
    [:nav
     (unordered-list [(link-to "/" "welcome")
                      (link-to "/results" "results")])]
    [:div#content content]]))

(defn welcome []
  (page "welcome"
        [:h1 "Welcome to Münster!"]
        [:p "I hope you're enjoying the presentation."]
        [:p "If you want to help improve it, please rate it below (1-Worst, 10-Best):"]
        (form-to [:post "/"]
                 (label :rating "Please choose: ")
                 [:select#rating {:name :rating}
                  (select-options (range 1 11))]
                 (submit-button "Rate now"))))

(defn render-average-rating [average-rating]
  (if average-rating
    [:p "On average this presentation has been rated as " average-rating "."]
    [:p "This presentation has not been rated yet."]))

(defn thank-you [own-rating average-rating]
  (page "thank you"
        [:h1 "Thank you ..."]
        [:p "... for rating this presentation as " own-rating "."]
        (render-average-rating average-rating)))

(defn results [average-rating]
  (page "results"
        [:h1 "Results"]
        (render-average-rating average-rating)))
