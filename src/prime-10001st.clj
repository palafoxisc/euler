(defn sqrt-trunk
  [n]
  (Math/round (Math/sqrt n)))

(defn next-j
  [index multiplier]
  (Math/round (+ (Math/pow index 2) (* multiplier index))))

(defn primes
  ([n array] (primes n array 2 (next-j 2 0) 1))
  ([n array index j pow]
;  (println "n" n "index" index "j" j "pow" pow "(sqrt-trunk n)" (sqrt-trunk n) "array" array)
  (if (< index (sqrt-trunk n))
    (if (nth array index)
      (if (<  j n)
        (recur n (assoc array j false) index (next-j index pow) (inc pow))
        (recur n array (inc index) (next-j (inc index) 0) 1))
      (recur n array (inc index) (next-j (inc index) 0) 1))
      array)))

(def lista (take 105000 (repeat true)))

;(println (map #(first %) (drop 2 (filter #(second %) (map-indexed vector (primes 39 (vec lista)))))))

(println (nth (map #(first %) (drop 2 (filter #(second %) (map-indexed vector (primes 105000 (vec lista)))))) 10000))
