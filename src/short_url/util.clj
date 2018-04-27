(ns short-url.util)

(defn gen-key []
  (apply str 
         (take 8 
               (repeatedly #(char (+ (rand 26) 65))))))