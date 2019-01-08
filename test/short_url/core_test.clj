(ns short-url.core-test
  (:require [clojure.test :refer :all]
            [short-url.core :refer :all]
            [short-url.util :refer [gen-key]]))

(deftest test-add
  (is 
   (= 2 
      (+ 1 1))))

(deftest test-gen-key
  (let [key (gen-key)]
    (is
     (= java.lang.String 
        (type key))
    (is
     (= 8 
        (count key))))))

(deftest test-get-url
  (let [data (get-url "WLPDWPNI")]
    (is
     (= clojure.lang.PersistentArrayMap
        (type data)))
    (is
     (= java.lang.String
        (type (:key data))))
    (is
     (= java.lang.String
        (type (:url data))))
    (is
      (= "WLPDWPNI"
         (:key data)))
    (is
      (= "https://github.com/u4bi"
         (:url data)))))


; Ran 3 tests containing 8 assertions.
; 0 failures, 0 errors.