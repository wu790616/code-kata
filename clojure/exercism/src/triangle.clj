(ns triangle)

(defn is-triangle?
  "Return true if all sides match triangle rule"
  [a b c]
  (let [max-side (max a b c)
        min-sum  (->> (sort [a b c])
                      (take 2)
                      (apply +))]
    (and (every? #(> % 0) [a b c])
         (> min-sum max-side))))


(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (and (is-triangle? a b c)
       (= a b c)))


(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  (and (is-triangle? a b c)
       (< (count (set [a b c])) 3)))


(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  (and (is-triangle? a b c)
       (= (count (set [a b c])) 3)))
