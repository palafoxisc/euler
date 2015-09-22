(defn exp 
  [x n]
  (reduce * (repeat n x)))

(println (reduce + (map #(. Integer parseInt %) (map str (seq (str (exp (bigint 2) 1000)))))))
