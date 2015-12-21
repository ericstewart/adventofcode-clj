(ns adventofcode.day-two
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn wrapping-paper-needed
  "Calculate total square feet of wrapping paper needed given package dimensions"
  [length width height]
  (let [surface1 (* length width)
        surface2 (* width height)
        surface3 (* height length)
        box-surface-area (reduce +
                                 (map (fn [item]
                                        (* 2 item))
                                      [surface1 surface2 surface3]))]
    (+ box-surface-area
       (min surface1 surface2 surface3))))

(def prob2-input
      (line-seq (io/reader (io/resource "day-2-inputs"))))


(defn calc-area-of-present
  [dimensions]
  (let [[l w h] (map (fn [s] (Integer/parseInt s))
                     (str/split dimensions #"x"))]
    (wrapping-paper-needed l w h)))

(defn total-paper-required
  [data]
  "Calculate the total wrapper paper needed for a whole lot of presents"
  (reduce +
          (map calc-area-of-present
               data)))

(defn ribbon-required
  [l w h]
  (reduce +
          (map (fn [a]
                 (+ a a))
               (take 2 (sort [l w h])))))

(defn bow-ribbon-required
  [l w h]
  (* l w h))

(defn total-ribbon
  [l w h]
  (+ (ribbon-required l w h)
     (bow-ribbon-required l w h)))

(defn total-ribbon-required
  [data]
  "Calculate the total ribbon needed for a whole lot of presents"
  (reduce +
          (map (fn [row]
                 (let [[l w h] (map (fn [s] (Integer/parseInt s))
                                    (str/split row #"x"))]
                   (total-ribbon l w h)))
               data)))
