(ns enlive-templating.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]))

(html/deftemplate random-number {:parser html/xml-parser}
  "templates/random-number.html"
  []
  [:div] (html/substitute (str (rand-int 10))))

(html/deftemplate signup {:parser html/xml-parser}
  "templates/signup.html"
  []
  [:div#pg_1] (html/substitute "Please sign up.")
)

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/random-number" [] (random-number))
  (GET "/signup" [] (signup))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
