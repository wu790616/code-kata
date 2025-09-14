(ns utils
  (:require
    [clojure.string :as str]))

(defn to-int [x]
  (Integer/parseInt x))

(defn read-data [path]
  (->> (slurp path)
       (str/split-lines)))
  
