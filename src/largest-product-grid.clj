(def content (slurp "src/grid.txt"))

(defn digits 
  [string]
  (map #(. Integer parseInt %)
    (reduce concat (map #(clojure.string/split % #" ") (clojure.string/split content #"\n")))))

(defn horizontal
  [index digits]
  (take 4 (drop index digits)))

(defn vertical
  [index digits]
  (take 4 (take-nth 20 (drop index digits))))


(defn vertical2
  [index digits]
  (take 4 (take-nth 21 (drop index digits))))

(defn diagonal
  [digits acc]
    (if (zero? (count digits))
      acc
      (recur (drop 21 digits) (conj acc (first digits)))))

; (defn largest-product
;  ([n] (largest-product n (to-digits content) []))
;  ([n digits products]
;   (if (zero? (first digits))
;    (recur n (rest digits) products)
;    (if (not (= n (count (take n digits))))
;     products
;     (recur n (rest digits) (cons (reduce * (take n digits)) products))))))

;(println (count (reduce concat (map #(clojure.string/split % #" ") (clojure.string/split content #"\n")))))
(println (digits content))
;(println (apply max (largest-product 13)))
(println (horizontal 4 (digits content)))
(println (vertical 0 (digits content)))
(println (vertical 1 (digits content)))
(println (diagonal (drop 1 (digits content)) []))
(println (vertical2 19 (digits content)))
