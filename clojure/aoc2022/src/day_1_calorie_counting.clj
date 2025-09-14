(ns day-1-calorie-counting
  (:require [clojure.string :as str]))

(def raw-data
  (slurp "data/day_1.txt"))

(defn sum-each-item [dd]
  (for [item dd]
    (->> (str/split item #"\n")
         (map read-string)
         (apply +))))

(def total-calories-list
  (-> raw-data
      (str/split #"\n\n")
      (sum-each-item)))

;; part-1
(defn get-max [data]
  (apply max data))

;; part-2
(defn sum-max-three [data]
  (->> data
       (sort)
       (take-last 3)
       (apply +)))

(comment
  (identity total-calories-list)
  (get-max total-calories-list)
  (sum-max-three total-calories-list))
