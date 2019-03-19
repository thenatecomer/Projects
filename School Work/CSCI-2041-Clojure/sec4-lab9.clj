(defn same-elements? [x y]
	(loop [x x y y z y]
		(cond 
			(empty? z) false
			(empty? x) true 
			(= (first x) (first z)) (recur (rest x) y y)
			(not= (first x) (first z)) (recur x y (rest z)))))

(defn sum-harmonic [n]
	(loop [c 1 t 0.0]
		(cond
			(> c n) t
			:else (recur (+ c 1) (+ t (/ c))))))

(defn collect [lst num]
	(loop [lst lst r '()]
		(cond
			(empty? lst) r
			:else (recur (take-last (- (count lst) num) lst) 
				(concat r (list (take num lst)))))))

(defn interleave [x y]
	(loop [x x y y r '()]
		(cond 
			(and (empty? x) (empty? y)) r			
			(empty? x) (concat r y)
			(empty? y) (concat r x)
			:else (recur (rest x) (rest y) 
				(concat r (list (first x)) (list (first y)))))))

(let [secret (atom "mistery")]
  (defn read-secret [] @secret)
  (defn multiply-secret [n] (reset! secret (repeat n @secret))))
	

			
