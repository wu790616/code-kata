(ns sum-consecutives)

;; https://www.codewars.com/kata/55eeddff3f64c954c2000059/clojure
(defn sum-consecutives [a]
  (->> a
       (partition-by identity)
       (map #(apply + %))
       (vec)))

(comment
  (sum-consecutives [1,4,4,4,0,4,3,3,1])) ;; [1 12 0 4 6 1]
