(ns user(:import java.lang.Math))
(defn prime? ([n] (cond (< n 3) true :else (prime? n 2)))
    ([n y]
      (cond
        (= (mod n y) 0) false
        (>= y (Math/sqrt n)) true
        :else (prime? n (+ y 1)))))

(defn sum-primes ([a b] (sum-primes a b 0))
  ([a b t]
    (cond
      (> a b) t
      (prime? a) (sum-primes (+ a 1) b (+ t a))
      (not (prime? a)) (sum-primes (+ a 1) b t))))


(defn sum-even ([a b] (sum-even a b 0))
  ([a b t]
   (cond
     (> a b) t
     (even? a) (sum-even (+ a 1) b (+ t a))
     (odd? a) (sum-even (+ a 1) b t))))
