(defproject short-url "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [compojure "1.6.1"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler short-url.core/handler})
