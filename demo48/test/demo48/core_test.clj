(ns demo48.core-test
  (:require [clojure.test :refer :all]
            [demo48.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest process-date-test
  (testing "process-date testing this func")
  (with-redefs [some-service-call (fn [] "mocked-response")]
    (let [result (process-date)]
      (is (= "processed: mocked-response" result))
      )
    )
  )