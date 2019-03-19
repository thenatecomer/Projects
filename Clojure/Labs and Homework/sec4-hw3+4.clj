(def p 6240322667N)
(def q 6240323147N)
(def n (* p q))
(def m (* (- p 1) (- q 1)))

(defn gcd [a b]
        (if (zero? b)
          a
          (recur b (mod a b))))

(defn rand-bigint "crude random number of type bigint" [n]
  (bigint (bigdec (rand n))))

(defn egcd "return list (s g t) s.t. a s + b t = g = gcd(a,b)" [a b]
  (letfn [(sign [x] (cond (pos? x) 1 (neg? x) -1 (zero? x) 0 :else nil))
	  (abs [x] (if (neg? x) (- x) x))]
	 ;; extended GCD
	 (cond (or (< a 0) (< b 0)) (map * (list (sign a) 1 (sign b)) (egcd (abs a) (abs b)))
	       (< a b) (reverse (egcd b a))
	       (= b 0) (list 1 a 0)
	       (= b 1) (list 0 1 1)
	       :else (let [q (quot a b)
			     r (mod a b)
			     w (egcd b r)]
			  (list (last w)
				(second w)
				(- (first w) (* q (last w))))))))

(defn modular-inverse "compute b s.t. a*b = 1 mod n, if it exists." [a n]
  (if (= n 0)
      (/ a)
      (let [result (egcd n a)]
           (if (= (second result) 1) ;; check if inverse exists...
               (mod (last result) n)
               nil))))

(defn expmod "compute base^exp mod m, fast" [base exp m]
  (cond (== exp 0)   1
	(neg? exp)  'error
        (even? exp) (mod ((fn [x] (* x x)) (expmod base (/ exp 2) m))
			 m)
	:else       (mod (* base (expmod base (- exp 1) m))
			 m)))

(defn find-e [m]
  (loop [x (rand-bigint m)]
    (cond
      (and (= 1 (gcd x m)) (not= nil (modular-inverse x m))) x
      :else (recur (rand-bigint m)))))

(def e (find-e m))

(def d (modular-inverse e m))

(defn make-public-key [n e]
  (list n e))

(def public-key (make-public-key n e))

(defn public-mod [publickey]
  (first publickey))

(defn public-exp [publickey]
  (first (rest publickey)))

(defn make-private-key [n d]
  (list n d))

(defn private-mod [privatekey]
  (first privatekey))

(defn private-inverse [privatekey]
  (first (rest privatekey)))

(def private-key (make-private-key n d))

(defn string->ascii ([x] (map  (fn [x] (- (int x) 32)) (seq x))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn ascii-num91 ([x] (ascii-num91 x 0))
  ([x t]
   (cond
     (empty? x) t
     :else (ascii-num91 (rest x) (+ t (* (exp 91 (- (count x) 1)) (first x)))))))

(defn encrypt-num [number publickey]
  (expmod number (public-exp publickey) (public-mod publickey)))

(defn encrypt-word [plaintext publickey]
  (encrypt-num (ascii-num91 (string->ascii plaintext)) publickey))

(defn log91 [x]
  (if (= 0 x) x
  (/ (Math/log x) (Math/log 91))))

(defn num91->num10 ([x] (num91->num10 x '() (int (log91 x))))
  ([x t c]
   (cond
     (= 0 x) t
     :else (num91->num10 (mod x (exp 91 c)) (concat t (list (int (/ x (exp 91 c))))) (- c 1)))))

(defn toastring [x]
  (apply str (map (fn [n] (char (+ n 32))) x)))

(defn decrypt-word [cyphertext privatekey]
  (toastring (num91->num10 (expmod cyphertext (private-inverse privatekey) (private-mod privatekey)))))

(defn encrypt-msg [msg publickey]
  (loop [msg (partition-by (fn [x] (= x \space)) msg) result '()]
    (cond
      (empty? msg) result
      :else (recur (rest msg) (concat result [(encrypt-word (first msg) publickey)])))))

(defn decrypt-msg [msg privatekey]
  (loop [msg (map (fn [x] (decrypt-word x privatekey)) msg) result ""]
    (cond
      (empty? msg) result
      (empty? (first msg)) (recur (rest msg) (str result " "))
      :else (recur (rest msg) (str result (first msg))))))

(defn encrypt-val [w key]
  (encrypt-num (ascii-num91 (string->ascii w)) key))

(defn decrypt-val [c key]
  (toastring (num91->num10 (expmod c (private-inverse key) (private-mod key)))))
















