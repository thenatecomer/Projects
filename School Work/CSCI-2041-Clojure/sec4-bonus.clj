(comment Nathan Comer)

(ns user(:import java.lang.Math))

(defn interl+ [a b]
	(loop [x a y b r '() c1 0 c2 0]
		(cond
			(and (> c1 0) (> c2 0)) r
			(empty? x) (recur a y r (+ c1 1) c2)
			(empty? y) (recur x b r c1 (+ c2 1))
			:else (recur (rest x) (rest y)
				(concat r (list (first x)) (list (first y))) c1 c2))))

(defn inter [a b n m]
    (lazy-seq (cons (first a) (cons (first b) (inter (if (empty? (rest a)) n (rest a)) (if (empty? (rest b)) m (rest b)) n m)))))

(defn interl+lazy [a b]
  (let [n a m b]
    (inter a b n m)))

(defn calc-pi [n]
  (loop [n n x (rand-int 1000000)
             y (rand-int 1000000)
         t 0]
    (cond
      (= n 0) t
      (< (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2))) 1000000) (recur (- n 1) (rand-int 1000000) (rand-int 1000000) (+ t 1))
      :else (recur (- n 1) (rand-int 1000000) (rand-int 1000000) t))))

(defn break-apart [n m]
  (let [n (if (odd? n) (+ n 1) n)]
  (loop [t n r '()]
    (cond
      (= t 0) r
      :else (recur (- t 1) (concat r [(/ m n)]))))))

(defn compute-pi [nthreads nsamples]
  (let [sum (pmap calc-pi (break-apart nthreads nsamples))]
  (* (/ (reduce + sum)
     nsamples) 4.0)))

(defn more-and-compare
  "Performs compute-pi m times with parameteres threads and samples then averages the results"
  [m threads samples]
  (loop [n m r 0.0]
    (cond
      (= n 0) (do (println "Difference between my value and Math/PI:" (- 100 (* (/ Math/PI (/ r m)) 100))"%") (/ r m))
      :else (recur (- n 1) (+ r (compute-pi threads samples))))))

(more-and-compare 10 10 100000)





