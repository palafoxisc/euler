(def primes '(2 3 5 7 11 13 17 19))

(defn itr
  ([] (itr (reduce * primes) 2))
  ([n i]
    (if (= i 21)
      n
      (if (zero? (mod n i))
        (recur n (inc i))
        (recur (inc n) 2)))))

(println (itr))
