(defproject bwertr "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.3.4"]
                 [com.cemerick/friend "0.2.1"]
                 [hiccup "1.0.5"]
                 [liberator "0.12.0"]
                 [org.clojure/clojure "1.6.0"]                 
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring "1.4.0-RC1"]]
  :profiles {:dev {:dependencies [[lein-ring "0.9.6"]
                                  [ring-mock "0.2.0"]]}}
  :plugins [[lein-ring "0.9.6"]]
  :ring {:handler bwertr.web.routes/app
         :auto-reload? true
         :auto-refresh? true?
         :nrepl {:start? true, :port 5555}})
