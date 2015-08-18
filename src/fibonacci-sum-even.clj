; suma los números pares en una serie fibonacci de hasta 4 millones

(let [lista [2 1]]
 (loop [[x & resto] lista]
  (if (> (+ x (first resto)) 4000000)
   (reduce + (filter even? (into [x] resto)))
   (recur (into [(+ x (first resto))] (into [x] resto))))))

(def sum-fibonacci 
 (reduce + (filter #(= (mod % 2) 0) (range 10))))

(println sum-fibonacci)
