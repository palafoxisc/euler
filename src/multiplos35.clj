(defn multiplo [n]
  (fn [x] (= (mod x n) 0)))

(def multiplo-3? (multiplo 3))

(def multiplo-5? (multiplo 5))

(defn multiplo-valido? [n]
  (or (multiplo-3? n) (multiplo-5? n)))

(defn multiplos [limite]
  (filter multiplo-valido? (range 1 limite)))

(println (reduce + (multiplos 1000)))
