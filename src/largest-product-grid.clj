(def content (slurp "src/grid.txt"))

(defn digits 
  [string]
  (map #(. Integer parseInt %)
    (reduce concat (map #(clojure.string/split % #" ") (clojure.string/split content #"\n")))))

(defn take-digits
  [index digits cant space]
  (take cant (take-nth space (drop index digits))))

(defn horizontal
  [index digits]
  (take-digits index digits 4 1))

(defn vertical
  [index digits]
  (take-digits index digits 4 20))

(defn diagonal
  [index digits]
  (take-digits index digits 4 21))

(defn inverted-diagonal
  [index digits]
  (take-digits index digits 4 19))

(defn build-map
  [n arr fun]
  {
    :product (reduce * (fun n arr)) 
    :values (fun n arr)
  })

(defn to-map
  [n arr]
  {
    :n n 
    :h (build-map n arr horizontal) 
    :v (build-map n arr vertical)
    :d (build-map n arr diagonal) 
    :di (build-map n arr inverted-diagonal)
  })

(defn largest-product
  [n arr acc]
  (if (> n 400)
    acc
    (recur (inc n) arr (conj acc (to-map n arr)))))

(def values (largest-product 0 (digits content) [])) 

(println (apply max (map #(get-in % [:h :product]) values)))
(println (apply max (map #(get-in % [:v :product]) values)))
(println (apply max (map #(get-in % [:d :product]) values)))
(println (apply max (map #(get-in % [:di :product]) values)))
