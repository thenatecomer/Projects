(defn integers [start]
      (cons start (lazy-seq (integers (inc start)))))

(defn lazy-rand [n]
	(lazy-seq (cons (rand-int (- n 1)) (lazy-rand (inc n)))))

(defn lazy-scale [lst f]
	(map (fn [x] (* x f)) lst))

(defn lazy-running-sum ([v] (lazy-running-sum v (first v)))
	([v t]
		(lazy-seq (cons t (lazy-running-sum (rest v) (+ t (first (rest v))))))))

(defn lazy-interleave [a b]
	(lazy-seq (cons (first a) (cons (first b) (lazy-interleave (rest a) (rest b))))))

(defn lazy-remove-dup ([lst] (lazy-remove-dup lst '()))
	([lst n]
		(cond
      (empty? lst) nil
			(not (some (fn [x] (= (first lst) x)) n))
				(lazy-seq (cons (first lst) (lazy-remove-dup (rest lst) (concat n [(first lst)]))))
			:else (lazy-seq (lazy-remove-dup (rest lst) n)))))
