(ns fake-binary)

(defn fake-bin [digits]
  (->> (for [item digits
             :let [num (Character/digit item 10)]]
         (if (< num 5) 0 1))
       (apply str)))
