(defn check
  [number index]
  (if (not (= index (/ number index)))
    [index (/ number index)]
    [index]))

(defn factors
  ([number] (factors number 1 []))
  ([number index acc]
    (if (>= index (inc (Math/sqrt number)))
      acc
      (if (zero? (mod number index))
        (recur number (inc index) (concat acc (check number index)))
        (recur number (inc index) acc)))))

(defn highly-div
  ([] (highly-div 2))
  ([start]
    (if (> (count (factors (reduce + (range (inc start))))) 500)
      (reduce + (range (inc start)))
      (recur (inc start)))))

(println (highly-div))
