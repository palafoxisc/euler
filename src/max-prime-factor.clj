(defn prime-factors
 ([n] (prime-factors n [] 2))
 ([n factors divisor]
  (if (> n 1)
   (if (= (mod n divisor) 0)
    (recur (long (/ n divisor)) (cons divisor factors) divisor)
    (recur n factors (inc divisor)))
   factors)))

(println (apply max (prime-factors 600851475143)))
