(ns enlive-templating.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/random-number" [] (random-number))
  (route/resources "/")
  (route/not-found "Not Found"))

(html/deftemplate random-number {:parser html/xml-parser}
  "templates/random-number.html"
  []
  [:div] (html/substitute (str (rand-int 10))))

(def app
  (handler/site app-routes))
