(ns day-4-camp-cleanup
  (:require
    [clojure.string :as str]
    [clojure.set :as set]))

(def raw-data
  (->> (slurp "data/day_4.txt")
       (str/split-lines)
       (map #(str/split % #","))))

(defn section-to-set [section]
  (let [[start end] (str/split section #"-")]
    (set (range (Integer/parseInt start) (+ 1 (Integer/parseInt end))))))

(defn part-1 []
  (reduce (fn [res pair]
            (let [[section-1 section-2] pair
                  set-1 (section-to-set section-1)
                  set-2 (section-to-set section-2)]
              (if (or (set/subset? set-1 set-2) (set/subset? set-2 set-1))
                (+ res 1)
                res)))
          0 raw-data))

(defn part-2 []
  (reduce (fn [res pair]
            (let [[section-1 section-2] pair
                  set-1 (section-to-set section-1)
                  set-2 (section-to-set section-2)]
              (if (empty? (set/intersection set-1 set-2))
                res
                (+ res 1))))
          0 raw-data))

(comment
  (identity raw-data)
  (section-to-set "41-75")
  (range 10 12)
  (part-1)
  (part-2))
