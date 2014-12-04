(ns my-proj.app
  (:use (compojure handler
    [core :only (GET POST defroutes)]))

  (:require
    compojure.route
    [net.cgrand.enlive-html :as en]
    [ring.util.response :as response]
    [ring.adapter.jetty :as jetty]))

(defonce counter (atom 10000))
(defonce urls (atom {}))

(defn shorten
  [url]
  (let [id (swap! counter inc)
        id (Long/toString id 36)]
  (swap! urls assoc id url)
  id))

(en/deftemplate homepage
  (en/xml-resource "homepage.html")
  [request]
  [:#listing :li] (en/clone-for [[id url] @urls]
    [:a] (comp
            (en/content (format "%s : %s" id url))
            (en/set-attr :href (str \/ id)))))

(defn redirect
  [id]
  (response/redirect (@urls id)))

(defroutes app*
  (compojure.route/resources "/")
  (GET "/" request (homepage request))
  (GET "/:id" [id] (redirect id))
  (POST "/shorten" request
  (let [id (shorten (-> request :params :url))]
  (response/redirect "/")))
  )

(def app (compojure.handler/site app*))
