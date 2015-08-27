(defn formula
  [a]
  (let [c (- 1000 a)]
    (/ (- (* c c) (* a a)) (* 2 c))))

(defn pythagorean-triplet
  [a b]
  (if (zero? (mod b (long b)))
    [a b (- 1000 (+ a b))]
    (recur (inc a) (formula (inc a)))))

(println (pythagorean-triplet 0 1.1))
(println (reduce * (pythagorean-triplet 0 1.1)))
