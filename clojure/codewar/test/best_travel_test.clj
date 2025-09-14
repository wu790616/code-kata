(ns best-travel-test
  (:require [clojure.test :refer :all]
            [best-travel :refer :all]))

(deftest a-test1
  (testing "Basic tests"
   (def ts [50, 55, 56, 57, 58])
   (is (= (choose-best-sum 163, 3, ts) 163))
   (def ts [50])
   (is (= (choose-best-sum 163, 3, ts) nil))))
  
