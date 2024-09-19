(ns demo47.core-test
  (:require [clojure.test :refer :all]
            [demo47.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest add-test
  (testing "testing add function for positive numbers")
  (is (= 30 (add 10 20)))

    (testing "testing add function for negative numbers")

  (is (= -30 (add -10 -20)))
  )

