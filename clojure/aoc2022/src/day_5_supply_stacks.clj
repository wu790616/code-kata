(ns day-5-supply-stacks
  (:require
    [utils :as utils]))

(def init-stacks
  {:1 ["B" "W" "N"]
   :2 ["L" "Z" "S" "P" "T" "D" "M" "B"]
   :3 ["Q" "H" "Z" "W" "R"]
   :4 ["W" "D" "V" "J" "Z" "R"]
   :5 ["S" "H" "M" "B"]
   :6 ["L" "G" "N" "J" "H" "V" "P" "B"]
   :7 ["J" "Q" "Z" "F" "H" "D" "L" "S"]
   :8 ["W" "S" "F" "J" "G" "Q" "B"]
   :9 ["Z" "W" "M" "S" "C" "D" "J"]})

(def raw-data
  (utils/read-data "data/day_5.txt"))

(defn move-stacks [step stacks reverse?]
  (let [[quant from to]         (re-seq #"\d+" step)
        [from-key to-key]       (map keyword [from to])
        [from-stacks to-stacks] (map #(get stacks %) [from-key to-key])
        quantity                (utils/to-int quant)
        moved-stacks            (if reverse? (reverse (take-last quantity from-stacks))
                                             (take-last quantity from-stacks))]
    (-> stacks
        (assoc from-key (vec (drop-last quantity from-stacks)))
        (assoc to-key (vec (flatten (conj to-stacks moved-stacks)))))))

(defn move [reverse?]
  (->> (reduce (fn [stacks step] (move-stacks step stacks reverse?)) init-stacks raw-data)
       (into (sorted-map))))
    
(comment
  (identity raw-data)
  (move-stacks "move 3 from 5 to 2" init-stacks false)
  (move-stacks "move 3 from 5 to 2" init-stacks true)
  (move true) ;; part-1
  (move false)) ;; part-2
