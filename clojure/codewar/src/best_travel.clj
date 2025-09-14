(ns best-travel)

(defn combinations [k ls]
  (cond
    (= k 0)     [[]]
    (empty? ls) []
    :else (concat (map #(conj % (first ls))
                       (combinations (dec k) (rest ls)))
                  (combinations k (rest ls)))))

(defn choose-best-sum [t k ls]
  (let [take-max #(if (empty? %) nil (apply max %))]
    (->> (combinations k ls)
         (map #(apply + %))
         (filter #(<= % t))
         (take-max))))

(comment
  (choose-best-sum 163, 3, [50, 55, 56, 57, 58])
  (choose-best-sum 163, 3, [50]))

;; How to get all combinations:
;;
;; 1. k = 1 => [[50] [55] [56] [57] [58]]
;; 2. k = 0 => [[]]
;; 3. ls = [] => []
;; 4. k = 3 / ls = [50 55 56 57 58]
;;    => [[50] + [55 56 57 58]/2]] + [55 56 57 58]/3
;;    => [[50] + ([55] + [56 57 58]/1) + ([56 57 58]/2)] + [55 56 57 58]/3
;;    => ......))
(comment
  (concat (map #(conj [55] %) [56 57 58])
          (concat (map #(conj [56] %) [57 58]) [[57 58]]))
  (combinations 3 [50 55 56 57 58])
  (combinations 4 [55 57 68]))
