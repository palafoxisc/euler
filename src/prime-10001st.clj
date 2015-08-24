(defn sqrt-trunk
  [n]
  (Math/round (Math/sqrt n)))

(defn next-j
  [index multiplier]
  (Math/round (+ (Math/pow index 2) (* multiplier index))))

(defn primes
  ([n array] (primes n array 2 (next-j 2 0) 1))
  ([n array index j pow]
  (println "n" n "index" index "j" j "pow" pow "(sqrt-trunk n)" (sqrt-trunk n) "array" array)
  (if (< index (sqrt-trunk n))
    (if (nth array index)
      (if (<  j n)
        (recur n (assoc array j false) index (next-j index pow) (inc pow))
        (recur n array (inc index) (next-j (inc index) 0) 1))
      (recur n array (inc index) (next-j (inc index) 0) 1))
      array)))



; (println (map-indexed vector (primes 18 [false false true true true true true true true true true true true true true true true true true true true])))

(def lista (take 40 (repeat true)))

(println (map-indexed vector (primes 39 (vec lista))))
