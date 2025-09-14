(ns day-2-rock-paper-scissors
  (:require
    [clojure.string :as str]
    [clojure.set :refer [map-invert]]))

;; Rock:     A / X
;; Paper:    B / Y
;; Scissors: C / Z
(def data
  (-> (slurp "data/day_2.txt")
      (str/split #"\n")))

(def score-map
  {"X"    1
   "Y"    2
   "Z"    3
   "lose" 0
   "draw" 3
   "won"  6})

(def game-map
  {"A" {"won"  "Y"
        "draw" "X"
        "lose" "Z"}
   "B" {"won"  "Z"
        "draw" "Y"
        "lose" "X"}
   "C" {"won"  "X"
        "draw" "Z"
        "lose" "Y"}})

(defn game-result [opponent mine]
  (-> (get game-map opponent)
      (map-invert)
      (get mine)))

(defn calculate-score [game]
  (let [opponent (str (first game))
        mine     (str (last  game))]
    (+ (get score-map mine)
       (get score-map (game-result opponent mine)))))

(defn part-1 []
  (->> (for [game data]
         (calculate-score game))
       (apply +)))

(defn part-2 []
  (let [res-map {"X" "lose"
                 "Y" "draw"
                 "Z" "won"}]
    (->> (for [game data
               :let [opponent (str (first game))
                     res      (get res-map (str (last game)))
                     mine     (get-in game-map [opponent res])]]
           (calculate-score (str opponent mine)))
         (apply +))))
  
(comment
  (identity data)
  (calculate-score "A X")
  (part-1)
  (part-2))
