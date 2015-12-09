(ns adventofcode.day-two-test
  (:require [clojure.test :refer :all]
            [adventofcode.day-two :refer :all]))

(deftest test-wrapping-paper
  (testing "calculation of wrapping paper"
    (is (= 58 (wrapping-paper-needed 2 3 4)))
    (is (= 43 (wrapping-paper-needed 1 1 10)))))

(deftest test-total-ribbon-required
  (testing "calculation of ribbon needed"
    (is (= 34 (total-ribbon 2 3 4)))
    (is (= 14 (total-ribbon 1 1 10)))))
