(ns user(:import java.lang.Math))
"Question 1"
(defn maxmul7 ([a b]
    (cond
      (> a b) nil
      (= (mod b 7) 0) b
      :else (maxmul7 a (- b 1)))))

"Question 2"
(defn sumcube ([a b] (sumcube a b 0))
  ([a b t]
    (cond
      (> a b) t
      :else (sumcube (+ a 1) b (+ t (* (* a a) a))))))

"Question 3"
(defn drop2nd [a]
  (concat (list (first a)) (drop 2 a)))

"Question 4"
(defn perfect ([a] (perfect a 0 1))
  ([a s c]
   (cond
     (>= c a) (= s a)
     (= (rem a c) 0) (perfect a (+ s c) (+ c 1))
     :else (perfect a s (+ c 1)))))

"Question 5"
(defn ave ([a] (ave a 0 0))
  ([a total count]
   (cond
     (= nil (first a)) (/ total count)
     :else (ave (rest a) (+ total (first a)) (+ count 1)))))

(defn stddev ([a]
  (do (def m (ave a))
   (Math/sqrt (ave (map (fn [x] (* (- x m) (- x m))) a) 0 -1)))))

"Question 6"
(defn posel ([a b] (pose1 a b 0))
  ([a b c]
    (cond
      (= nil (first a)) nil
      (= b (first a)) c
      :else (pose1 (rest a) b (+ c 1)))))



