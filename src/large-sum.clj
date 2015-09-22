(def content (slurp "src/large-numbers.txt"))

(def numbers 
  (map #(bigint %) (clojure.string/split content #"\n")))

(println (take 10 (str (reduce + numbers))))
