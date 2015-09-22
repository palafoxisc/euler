(def content (slurp "src/large-numbers.txt"))

(def numbers 
  (map #(new BigInteger %) (clojure.string/split content #"\n")))

(defn sum
  [x y]
  (. x add y))

(println (subs (str (reduce sum numbers)) 0 10))
