(defn sum
  [n]
  (let [numbers (range (inc n))]
    (- (* (reduce + numbers)  (reduce + numbers)) (reduce + (map #(* % %) numbers)))))

(println (sum 100))
