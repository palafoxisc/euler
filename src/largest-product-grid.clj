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

(defn diagonal
  [index digits]
  (take 4 (take-nth 21 (drop index digits))))

(defn diagonal2
  [index digits]
  (take 4 (take-nth 19 (drop index digits))))

(defn to-map
  [n arr]
  {:n n :h {:product (reduce * (horizontal n arr)) :values (horizontal n arr)} :v {:product (reduce * (vertical n arr)) :values (vertical n arr)} :d {:product (reduce * (diagonal n arr)) :values (diagonal n arr)} :di {:product (reduce * (diagonal2 n arr)) :values (diagonal2 n arr)} })

(defn largest-product
  [n arr acc]
;  (println "n" n "arr" arr "acc" acc)
  (if (> n 400)
    acc
    (recur (inc n) arr (conj acc (to-map n arr)))))

;(println (count (reduce concat (map #(clojure.string/split % #" ") (clojure.string/split content #"\n")))))
;(println (digits content))
;(println (apply max (largest-product 13)))
;(println (horizontal 4 (digits content)))
;(println (vertical 0 (digits content)))
;(println (vertical 1 (digits content)))
;(println (diagonal 3 (digits content)))
;(println (diagonal2 7 (digits content)))

;(println (largest-product 0 (digits content) []))
;(println (map #(get-in % [:v]) (largest-product 0 (digits content) [])))
(println (apply max (map #(get-in % [:h :product]) (largest-product 0 (digits content) []))))
(println (apply max (map #(get-in % [:v :product]) (largest-product 0 (digits content) []))))
(println (apply max (map #(get-in % [:d :product]) (largest-product 0 (digits content) []))))
(println (apply max (map #(get-in % [:di :product]) (largest-product 0 (digits content) []))))
;(println (apply max (largest-product 0 (digits content) [])))
