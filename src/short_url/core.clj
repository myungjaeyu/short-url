(ns short-url.core
  (:use ring.util.response)
  (:require [compojure.core :refer :all]
            [compojure.handler :as h]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [short-url.db :as db]
            [short-url.util :refer [gen-key]]))

(defn insert-url [url]
  (db/insert-url (gen-key) url))

(defn get-url [key]
  (db/get-url key))

(defn delete-url [key]
  (let [deleted (db/delete-url key)]
    {:deleted (cond 
                (= deleted 1) true
                :else false)}))

(defroutes handler
  (context "/api" []
           (POST "/" [url] (response
                            (insert-url url)))
           (GET "/:key" [key] (response
                               (get-url key)))
           (DELETE "/" [key] (response
                              (delete-url key))))
  (route/not-found (response
                    {:message "not found"})))

(def app
  (wrap-json-response 
   (h/api handler)))