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

(def primes-list (take 105000 (repeat true)))

(println (nth (map #(first %) (drop 2 (filter #(second %) (map-indexed vector (primes 105000 (vec primes-list)))))) 10000))
