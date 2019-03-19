(defn num-digits [n]
  (count (str n)))

(defn from-dec [n base]
  (loop [n n new '()]
    (cond
      (pos? n) (recur (quot n base) (conj new (mod n base)))
      :else new)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn to-dec [n base]
  (loop [n n new 0]
    (cond
      (empty? n) new
      :else (recur (rest n) (+ new (* (first n) (exp base (- (count n) 1))))))))

(defn gcd [x y]
  (loop [x x y y]
    (cond
      (= 0 y) x
      :else (recur y (rem x y)))))