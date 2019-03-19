(defn remove-dupl [a b]
        (concat (filter (fn [x] (= nil (some #{x} b))) a) (filter (fn [y] (= nil (some #{y} a))) b)))


(defn reduce ([f c]
    (cond
      (= nil (first c)) (f)
      (= nil (next c)) (first c)
      :else (reduce f (rest c) (first c))))
  ([f c r]
   (cond
     (= nil (next c)) (f r (first c))
     :else (reduce f (rest c) (f r (first c))))))


