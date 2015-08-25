(defn sqrt-trunk
  [n]
  (Math/round (Math/sqrt n)))

(defn next-j
  [index multiplier]
  (Math/round (+ (Math/pow index 2) (* multiplier index))))

(defn primes
  ([limit array] (primes limit array 2 4 1))
  ([limit array index j multiplier]
    (if (< index (sqrt-trunk limit))
      (if (nth array index)
        (if (<  j limit)
          (recur limit (assoc array j false) index (next-j index multiplier) (inc multiplier))
          (recur limit array (inc index) (next-j (inc index) 0) 1))
        (recur limit array (inc index) (next-j (inc index) 0) 1))
      array)))

(def bool-array (take 105000 (repeat true)))

(def only-primes (drop 2 (filter #(second %) (map-indexed vector (primes 105000 (vec bool-array))))))

(def primes-numbers (map #(first %) only-primes))

(println (nth primes-numbers 10000)) ; vector starts at 0
