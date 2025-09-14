(ns day-3-rucksack-reorganization
  (:require
    [clojure.string :as str]
    [clojure.set :refer [intersection]]))

(def raw-data
  (-> (slurp "data/day_3.txt")
      (str/split-lines)))

(def char-map
  (apply str (map char (concat (range 97 123) (range 65 91)))))

(defn find-dup [sets]
  (->> (map set sets)
       (reduce #(intersection %2 %1))
       (first)))

(defn char-score [ch]
  (+ 1 (str/index-of char-map ch)))

(defn part-1 []
  (->> (for [line raw-data
             :let [line-length (count line)
                   sets (partition (/ line-length 2) line)]]
         (char-score (find-dup sets)))
       (apply +)))

(defn part-2 []
  (let [groups (partition 3 raw-data)]
    (->> (for [group groups]
           (-> (find-dup group)
               (char-score)))
         (apply +))))

(comment
  (identity raw-data)
  (identity char-map)
  (find-dup (partition 12 "vJrwpWtwJgWrhcsFMMfFFhFp"))
  (find-dup '("cab" "cbba" "cdb" "ac"))
  (char-score \p)
  (part-1)
  (part-2))
