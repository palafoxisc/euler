;(def primes '(2 3 5 7 11 13 17 19))

;(defn itr
; ([] (itr 2520 primes))
; ([n i]
;   (if (empty? i)
;     n
;     (if (zero? (mod n (first i)))
;       (recur n (rest i))
;       (recur (inc n) primes)))))

(defn itr
  ([] (itr 2520 2))
    ([n i]
    (if (= i 21)
      n
      (if (zero? (mod n i))
       (recur n (inc i))
       (recur (inc n) 2)))))

(println (itr))
