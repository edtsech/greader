(defproject grrr "0.1.0-SNAPSHOT"
  :description "Github Readme ReadeR"
  :url "grrrapp.heroku.com"
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [lib-noir "0.4.9"]
                 [compojure "1.1.5"]
                 [clabango "0.4"]
                 [ring-server "0.2.7"]
                 [me.raynes/laser "1.1.1"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler grrr.handler/war-handler
         :init    grrr.handler/init
         :destroy grrr.handler/destroy}
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.3"]
                        [ring/ring-devel "1.1.8"]]}}
  :min-lein-version "2.0.0")
