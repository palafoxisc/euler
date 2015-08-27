(defn formula
  [a]
  (/ (- (* (- 1000 a) (- 1000 a)) (* a a)) (* 2 (- 1000 a))))

(defn pythagorean-triplet
  [a b]
  (if (zero? (mod b (long b)))
    [ a b (- 1000 (+ a b))]
    (recur (inc a) (formula (inc a)))))

(println (pythagorean-triplet 0 1.1))
(println (reduce * (pythagorean-triplet 0 1.1)))
