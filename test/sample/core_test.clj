(ns sample.core-test
  (:require [midje.sweet :refer :all]
            [ring.util.http-predicates :refer :all]))

(fact "math"
  (+ 1 1) => 2)
