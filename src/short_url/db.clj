(ns short-url.db
    (:require [clojure.java.jdbc :as sql]))

(def conn {:dbtype "postgresql"
           :dbname "postgres"
           :host "localhost"
           :port 5432})

(defn get-url [key]
  (sql/query conn
             ["SELECT *
                FROM
                    short_url_table
                where
                    key = ?" key]
             {:result-set-fn first}))

(defn insert-url [key url]
  (first
   (sql/insert! conn
                :short_url_table {
                                 :key key
                                 :url url})))

(defn delete-url [key]
  (first
   (sql/delete! conn
                :short_url_table ["key = ?" key])))


; CREATE TABLE short_url_table ( id SERIAL PRIMARY KEY, key VARCHAR(8) NOT NULL, url VARCHAR(255) NOT NULL);