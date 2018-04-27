(ns short-url.core
  (:use ring.util.response)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]))

(defroutes handler
  (GET "/" [] (response {:message "u4bi"}))
  (route/not-found (response {:message "not found"})))

(def app
  (wrap-json-response handler))