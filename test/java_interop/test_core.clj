(ns java-interop.test-core
  (:use java-interop.core
        midje.sweet))

(facts "randoms"
       (randoms 1 3)
         => [-1155869325 431529176 1761283695]
       (randoms 1337 5)
         => [-1460590454 747279288 -1334692577 -539670452 -501340078])

(facts "arraylist-flatten"
       (seq (arraylist-flatten [])) => empty?
       (seq (arraylist-flatten [[]])) => empty?
       (seq (arraylist-flatten [[1 2]])) => [1 2]
       (seq (arraylist-flatten [[1 2 3] [4 5 6]])) => [1 2 3 4 5 6]
       (.getClass (arraylist-flatten [[1 2 3] [4 5 6]])) 
           => java.util.ArrayList)

(facts "callable-pony"
       (instance? Callable (callable-pony)) => true
       (.call (callable-pony)) => :pony)

(facts "minimum-str"
       (minimum-str #{"abc" "cat" ":D"}) => ":D"
       (minimum-str ["OMG" "ponies" ""]) => "")
