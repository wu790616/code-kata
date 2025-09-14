(ns split-strings)

(defn solution [s]
  (let [strings (if (odd? (count s)) (str s "_") s)]
    (->> strings
         (re-seq #".{1,2}")
         (vec))))

(comment
  (solution "cdabefg"))
