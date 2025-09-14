(ns duplicate-encoder
  (:require [clojure.string :as str]))

;; https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/clojure
(defn encode-dups [text]
  (let [lower-text (str/lower-case text)
        count-map (frequencies lower-text)]
    (->> (map #(if (> (get count-map %) 1) ")" "(") lower-text)
         (apply str))))

(comment
  (encode-dups "aabbcDdE"))
