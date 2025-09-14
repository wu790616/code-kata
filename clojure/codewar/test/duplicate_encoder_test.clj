(ns duplicate-encoder-test
  (:require [clojure.test :refer :all]
            [duplicate-encoder :refer [encode-dups]]))

(defn dotest [text expected]
  (is (= (encode-dups text) expected)))

(deftest sample
  (testing "basic"
    (dotest "din" "(((")
    (dotest "recede" "()()()")
    (dotest "(( @" "))((")
    (dotest "ABC" "(((")
    (dotest "AaBbC" "))))("))
  
  (testing "ignore-case" (dotest "Success" ")())())")))
