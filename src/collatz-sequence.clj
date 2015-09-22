(defn func
  [n]
  (if (even? n)
    (/ n 2)
    (+ (* n 3) 1)))

(defn collatz-seq
  ([n] (collatz-seq n [n]))
  ([n acc]
    (if (= n 1)
      acc
      (recur (func n) (conj acc (func n))))))

(defn max-list
  [x y]
  (if (> (count x) (count y)) x y))

(defn collatz-max-seq
  ([limit] (collatz-max-seq limit []))
  ([limit max-seq]
    (if (= limit 1)
      max-seq
      (recur (dec limit) (max-list max-seq (collatz-seq limit))))))


(println (collatz-max-seq 1000000))
