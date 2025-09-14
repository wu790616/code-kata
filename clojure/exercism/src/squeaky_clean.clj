(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn filter-letter [s]
  (->> s
       (filter #(or (Character/isLetter %)
                    (= \_ %)))
       (apply str)))

(defn clean
  [s]
  (-> s
      (str/replace #" " "_")
      (str/replace #"[\u0000-\u001F\u007F-\u009F]" "CTRL")
      (str/replace #"[α-ω]" "")
      (str/replace #"\-(.)" #(.toUpperCase (%1 1)))
      (filter-letter)))
