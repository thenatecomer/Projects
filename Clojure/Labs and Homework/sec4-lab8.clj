(defmacro avg [x & args]
	(/ (+ x (apply + args)) (+ (count args) 1.0)))

(defmacro avg-vect [v]
	(/ (apply + v) (+ (count v) 0.0)))

(defmacro numif [e p z n]
	`(cond
		(> ~e 0) ~p
		(= ~e 0) ~z
		(< ~e 0) ~n))

(defmacro ntimes [n & body]
  (let [sym (gensym)]
    `(loop [~sym ~n]
      (if (> ~sym 0)
        (do ~@body (recur (dec ~sym)))
        nil))))

(defmacro my-dotimes [[x init end] & body]
  `(let [finish# ~end]
     (loop [~x ~init]
       (when (< ~x finish#)
         ~@body
         (recur (inc ~x))))))
