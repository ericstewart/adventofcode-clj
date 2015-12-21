(ns adventofcode.day-one
  (:require
    [clojure.java.io :as io]))

(def prob1-input (slurp (io/resource "day-1-input")))

(defn floor-adjustment
  [input]
  (map {\( 1 \) -1} input))

(defn calc-floor
  [input]
  (reduce + (floor-adjustment input)))

(defn positions
  "Returns a lazy sequence containing the positions at which pred
   is true for items in coll."
  [pred coll]
  (for [[idx elt] (map-indexed vector coll) :when (pred elt)] idx))

(defn floor-history [input]
  (reductions +
              0
              (floor-adjustment input)))

(defn find-floor-target
  [input target-floor]
  (first (positions #{target-floor}
                    (floor-history (vec (seq input))))))

