(ns short-url.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes handler
  (GET "/" [] "<h1>u4bi</h1>")
  (route/not-found "<h1>404</h1>"))