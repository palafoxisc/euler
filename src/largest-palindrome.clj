(require '[clojure.string :as s])

(defn palindrome?
  [n]
  (let[number (str n)]
    (if (= number (s/reverse number)) true false)))

(defn largest
  ([n] (largest n n []))
  ([i j p]
    (if (and (= i 100) (= j 100))
      p
      (if (= j 100)
        (recur (dec i) (dec i) p)
        (if (palindrome? (* i j))
          (recur i (dec j) (cons (* i j) p))
          (recur i (dec j) p))))))

(println (apply max (largest 999)))
