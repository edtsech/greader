(ns grrr.routes.home
  (:use compojure.core)
  (:require [grrr.views.layout :as layout]
            [grrr.util :as util]
            [me.raynes.laser :as laser]))

(defn build-url [user project]
  (str "https://github.com/" user "/" project))

(defn extract-readme [phtml]
  (laser/to-html (first (laser/select phtml
                                      (laser/class= :markdown-body)))))

(defn extract-links [phtml]
  (let [headers (laser/select phtml (laser/element= :h2))]
    (map (fn [x]
           {:url (-> x :content second :attrs :href)
            :name (apply str (map laser/to-html
                                  (-> x :content rest rest)))})
         headers)))

(defn render-readme [user project]
  (let [url (build-url user project)
        html (slurp url)
        phtml (laser/parse html)]

    (layout/render "base.html" {:content (extract-readme phtml)
                                :links (extract-links phtml)
                                :url url})))

(defroutes home-routes
  (GET "/" []
       (render-readme "edtsech" "grrr"))
  (GET "/:user/:project" [user project]
       (render-readme user project)))
