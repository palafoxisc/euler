; Suma los múltiplos de 3 y de 5 debajo de 1000
(defn multiplo [n]
  (fn [x] (= (mod x n) 0)))

(def multiplo-3? (multiplo 3))

(def multiplo-5? (multiplo 5))

(defn multiplo-valido? [n]
  (or (multiplo-3? n) (multiplo-5? n)))

(defn multiplos [limite]
  (filter multiplo-valido? (range 1 limite)))

(println (reduce + (multiplos 1000)))

; en una línea de código
; (reduce + (filter #(or (= (mod % 3) 0) (= (mod % 5) 0)) (range 1000)))

