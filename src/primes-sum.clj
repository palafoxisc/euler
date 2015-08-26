(def limit 2000000)

(def base-array (take limit (repeat true)))

(defn sqrt-trunk
  [n]
  (Math/round (Math/sqrt n)))

(defn next-index
  [index multiplier]
  (Math/round (+ (Math/pow index 2) (* multiplier index))))

(defn search-primes
  ([limit array] (search-primes limit array 2 4 1))
  ([limit array index j multiplier]
    (if (< index (sqrt-trunk limit))
      (if (nth array index)
        (if (<  j limit)
          (recur limit (assoc array j false) index (next-index index multiplier) (inc multiplier))
          (recur limit array (inc index) (next-index (inc index) 0) 1))
        (recur limit array (inc index) (next-index (inc index) 0) 1))
      array)))

(def clear-array (drop 2 (filter #(second %) (map-indexed vector (search-primes limit (vec base-array))))))

(def primes-numbers (map #(first %) clear-array))

(println (reduce + (take-while #(< % limit) primes-numbers)))

