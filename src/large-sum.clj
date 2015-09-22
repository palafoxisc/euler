(def content (slurp "src/large-numbers.txt"))

(def numbers 
  (map #(bigint %) (clojure.string/split content #"\n")))

(println (subs (str (reduce + numbers)) 0 10))

;(println (apply str (take 10 (str (reduce + numbers)))))
