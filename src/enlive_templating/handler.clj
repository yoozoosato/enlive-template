(ns enlive-templating.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]))

(html/deftemplate random-number {:parser html/xml-parser}
  "templates/random-number.html"
  []
  [:div] (html/substitute (str (rand-int 10))))

(html/deftemplate signup "templates/signup.html"
  []
  [:div#pg_1] (html/substitute "Please sign up.")
)

(html/deftemplate welcome "templates/welcome.html"
  []
  [:div#pg_1] (html/substitute "name")
)

(defroutes app-routes
  (GET "/" [] "<a href=\"/signup\">signup<a>")
  (GET "/random-number" [] (random-number))
  (GET "/signup" [] (signup))
  (GET "/welcome" [] (welcome))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
