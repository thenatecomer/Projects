(defn replace-with-sum ([x] (replace-with-sum x '() 0))
  ([x y t]
   (cond
    (empty? x) (if (not= 0 t) (concat y (list t)) y)
    (not (number? (first x))) (replace-with-sum (rest x) (concat y (list (first x))) t)
    :else (replace-with-sum (rest x) y (+ t (first x))))))

(defn running-sum ([x] (running-sum x '() 0))
  ([x y s]
   (cond
    (empty? x) y
    :else (running-sum (rest x) (concat y (list (+ s (first x)))) (+ s (first x))))))

(defn expand ([x] (expand (map inner-expand-fn x) '()))
  ([x y]
   (cond
     (or (empty? x) (empty? (rest x))) (concat y (list (first x)))
     :else (expand (rest x) (concat y (list (first x)))))))

(defn inner-expand-fn ([x]
                       (cond (not (list? x)) x
                        :else (inner-expand-fn (rest x) (first x) '())))
  ([x n y]
   (cond
     (= n 0) y
     :else (inner-expand-fn x (- n 1) (concat y x)))))

(defn factors ([r n] (factors r n '()))
  ([r n l]
   (cond
     (empty? r) l
     (= (mod n (first r)) 0) (factors (rest r) n (concat l (list (first r))))
     :else (factors (rest r) n l))))

(defn string->ascii ([x] (map  (fn [x] (- (int x) 32)) (seq x))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn ascii-num96 ([x] (ascii-num96 x 0))
  ([x t]
   (cond
     (empty? x) t
     :else (ascii-num96 (rest x) (+ t (* (exp 96 (- (count x) 1)) (first x)))))))

(defn make-dict ([x] (make-dict x {}))
  ([x d]
   (cond
     (empty? x) d
     :else (make-dict (rest x) (assoc d (first x) (ascii-num96 (string->ascii (first x))))))))

(defn in-dict [x y]
  (cond
    (contains? x y) (get x y)
    :else nil))

(defn fast-prime? "randomized prime tester, default 40 times" [n & opt-times]
  (loop [times (or (first opt-times) 40)]
        (cond (= times 0)     true
	      (fermat-test n) (recur (- times 1))
	      :else           false)))

(defn strongprimes ([v] (strongprimes v '()))
	([v r]
		(cond
			(empty? v) r
			(or (= 2 (first v)) (fast-prime? (/ (- (first v) 1) 2)))
				(strongprimes (rest v) (concat r (list (first v))))
			:else (strongprimes (rest v) r))))

(comment
user=> (fast-prime? 93843)
false
user=> (fast-prime? 3842747)
false
user=> (fast-prime? 293037)
false
user=> (fast-prime? 219)
false
user=> (fast-prime? 15485867)
true
)
