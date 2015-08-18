; suma los números pares en una serie fibonacci de hasta 4 millones

;(defn even? [n]
    ;  (= (mod n 2) 0))

(defn fibonacci-list [n] 
 (let [lista [2 1]] (loop [x & resto] (concat (+ x (first resto)) lista) (if (< (+ x (first resto)) n) (recur lista)))))

(def lista [1 2 3 4 5])
  (loop [[x & resto] lista]
   (if (< x 4)
    (loop resto)
    (println x)))


  (loop [iteration 0 [x & resto] lista]
   (println (str "Iteration " iteration " " x))
   (if (> iteration 3)
    (println "Goodbye!" x)
    (recur (inc iteration) resto)))


(def lista [2 1])

  (let [lista [2 1]]
   (loop [[x & resto] lista]
    (println (str "suma " (+ x (first resto))))
    (if (> (+ x (first resto)) 100)
     (into [(+ x (first resto))] (into [x] resto))
     (recur (into [(+ x (first resto))] (into [x] resto))))))


  (let [lista [2 1]]
   (loop [[x & resto] lista]
    (if (> (+ x (first resto)) 4000000)
     (reduce + (filter #(= (mod % 2) 0) (into [x] resto)))
     (recur (into [(+ x (first resto))] (into [x] resto))))))

  (let [lista [2 1]]
   (loop [[x & resto] lista]
    (if (> (+ x (first resto)) 4000000)
     (reduce + (filter even? (into [x] resto)))
     (recur (into [(+ x (first resto))] (into [x] resto))))))

(let [lista [2 1]]
 (loop [[x & resto] lista]
  (println (str "suma " (+ x (first resto))))
  (if (> (+ x (first resto)) 100)
   (println "Goodbye!" resto)
   (recur (into [(+ x (first resto))] (into [x] resto))))))

(def sum-fibonacci 
  (reduce + (filter #(= (mod % 2) 0) (range 10))))

(println sum-fibonacci)
