(defmacro car [x]
	`(first ~x))

(defmacro my-if ([x1 x2 x3 x4 x5]
	`(if ~x1 ~x3 ~x5))	
([x1 x2 x3]
	`(if ~x1 ~x3)))

(defn lazy-interleave [x y]
	(loop [x x y y r '()]
		(cond
			(and (empty? x) (empty? y)) r
			(empty? x) (concat r y)
			(empty? y) (concat r x)
			:else (recur (rest x) (rest y) (concat r [(first x)] [(first y)])))))

(defn lazy-random [n]
	(lazy-seq (cons (rand-int n) (lazy-random (inc n)))))

(let [num (atom 1) val @num]
	(swap! num inc)
	(println "previous:" val)
	@num)
(comment previous: 1
2)

(def ag (agent {}))
(defn action [m key]
	(assoc m key 10))
(send ag action :b)
(comment {:b 10})


(binding [x 2 y 3]
	(set! x (+ x y)))
(comment 5)
