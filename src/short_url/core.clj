(ns short-url.core)

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "<h1>u4bi</h1>"})