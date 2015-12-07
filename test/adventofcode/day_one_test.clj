(ns adventofcode.day-one-test  
  (:require [clojure.test :refer :all]
            [adventofcode.day-one :refer :all]))

(deftest single-characters
  (testing "single character cases"
    (is (= 1 (calc-floor "(")))
    (is (= -1 (calc-floor ")")))))

(deftest two-characters
  (testing "single character cases"
    (is (= 2 (calc-floor "((")))
    (is (= -2 (calc-floor "))")))
    (is (= 0 (calc-floor "()")))
    (is (= 0 (calc-floor ")(")))))

(deftest test-find-first-floor-entry
  (testing "simple cases of finding the basement entry"
    (is (= 1 (find-floor-target ")" -1)))
    (is (= nil (find-floor-target "(" -1)))
    (is (= 3 (find-floor-target "())" -1)))))

