(ns two-sum)

;; https://www.codewars.com/kata/52c31f8e6605bcc646000082/clojure
(defn twosum [numbers target]
  (let [num-size (count numbers)]
    (first (for [x (range num-size) y (range num-size)
                 :when (and (not= x y)
                            (= target (+ (get numbers x) (get numbers y))))]
             [x y]))))

(comment
  (twosum [1 2 3] 4))
