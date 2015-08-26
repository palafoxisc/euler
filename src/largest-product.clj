(def content (slurp "src/numbers.txt"))

(defn to-digits 
  [string]
  (map #(. Integer parseInt (. Character toString %))
    (reduce concat (clojure.string/split string #"\n"))))

(defn largest-product
  ([n] (largest-product n (to-digits content) []))
  ([n digits products]
    (if (zero? (first digits))
      (recur n (rest digits) products)
      (if (not (= n (count (take n digits))))
        products
        (recur n (rest digits) (cons (reduce * (take n digits)) products))))))

(println (apply max (largest-product 13)))

;{:prod (reduce * (take 13 digits)) :digits (take 13 digits)}
