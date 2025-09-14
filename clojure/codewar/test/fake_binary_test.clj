(ns fake-binary-test
  (:require [clojure.test :refer :all]
            [fake-binary  :refer [fake-bin]]))

(deftest basic-tests
  (is (= (fake-bin "45385593107843568"          ) "01011110001100111"))
  (is (= (fake-bin "509321967506747"            ) "101000111101101"))
  (is (= (fake-bin "366058562030849490134388085") "011011110000101010000011011")))
