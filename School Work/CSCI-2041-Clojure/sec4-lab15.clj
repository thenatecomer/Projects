(defmacro time [expr]
`(let [start# (. System (nanoTime)) ret# ~expr]
(prn (str "Elapse time: "
	[(/ (double (- (. System (nanoTime)) start#)) 1000000.0) " msecs" ret#]))
ret#))

(defmacro definefcn [f ar & b]
	`(def ~f (fn [~ar] ~@b)))
