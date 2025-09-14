(ns is-n-divisible-by-x-and-y-test
  (:require [clojure.test :refer :all]
            [is-n-divisible-by-x-and-y :refer [is-divisible]]))

(defn tester [a b c exp]
  (testing (str "(isDivisible " a " " b " " c ")")
    (is (= (is-divisible a b c) exp))))

(deftest basic-tests
  (tester 3 3 4 false)
  (tester 12 3 4 true)
  (tester 8 3 4 false)
  (tester 48 3 4 true)
  (tester 100 5 10 true)
  (tester 100 5 3 false)
  (tester 4 4 2 true)
  (tester 5 2 3 false)
  (tester 17 17 17 true)
  (tester 17 1 17 true))
