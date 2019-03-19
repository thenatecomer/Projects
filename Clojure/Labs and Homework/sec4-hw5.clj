(def Ahistory (atom '()))
(def Bhistory (atom '()))
(def GameMatrix {:DC 5 :CD 0 :CC 3 :DD 1})


(defn all-defect [ownh opph]
  'd)

(defn all-cooperate [ownh opph]
  'c)

(defn random [ownh opph]
  (let [r (rand-int 2)]
    (cond
      (= r 1) 'c
      :else 'd)))

(defn tit-for-tat [ownh opph]
  (cond
    (empty? @ownh) 'c
    :else (last @opph)))

(defn tit-for-two-tats [ownh opph]
  (cond
    (< 2 (count (take-last 2 @opph))) 'c
    (and (= 'd (first (take-last 2 @opph))) (= 'd (last @opph))) 'd
    :else 'c))


(defn compete-n-times [strategy1 strategy2 n]
  (do
    (reset! Ahistory '())
    (reset! Bhistory '())
  (loop [Achoice (strategy1 Ahistory Bhistory) Bchoice (strategy2 Bhistory Ahistory) Awin 0 Bwin 0 n n]
    (cond
      (<= n 0)
        (cond
          (> Awin Bwin) (println "PlayerA won   PlayerB lost    Final Score   PlayerA:" Awin "  PlayerB:" Bwin)
          (< Awin Bwin) (println "PlayerA lost  PlayerB won     Final Score   PlayerA:" Awin "  PlayerB:" Bwin)
          :else (println "The two players tied!         Final Score   PlayerA:" Awin "  PlayerB:" Bwin))

      (and (= Achoice 'c) (= Bchoice 'c))
        (do
          (swap! Ahistory (fn [x] (concat x [Achoice])))
          (swap! Bhistory (fn [x] (concat x [Bchoice])))
          (recur (strategy1 Ahistory Bhistory) (strategy2 Bhistory Ahistory) (+ Awin (get GameMatrix :CC)) (+ Bwin (get GameMatrix :CC)) (- n 1)))

      (and (= Achoice 'd) (= Bchoice 'd))
        (do
          (swap! Ahistory (fn [x] (concat x [Achoice])))
          (swap! Bhistory (fn [x] (concat x [Bchoice])))
          (recur (strategy1 Ahistory Bhistory) (strategy2 Bhistory Ahistory) (+ Awin (get GameMatrix :DD)) (+ Bwin (get GameMatrix :DD)) (- n 1)))

      (and (= Achoice 'c) (= Bchoice 'd))
        (do
          (swap! Ahistory (fn [x] (concat x [Achoice])))
          (swap! Bhistory (fn [x] (concat x [Bchoice])))
          (recur (strategy1 Ahistory Bhistory) (strategy2 Bhistory Ahistory) (+ Awin (get GameMatrix :CD)) (+ Bwin (get GameMatrix :DC)) (- n 1)))
      (and (= Achoice 'd) (= Bchoice 'c))
        (do
          (swap! Ahistory (fn [x] (concat x [Achoice])))
          (swap! Bhistory (fn [x] (concat x [Bchoice])))
          (recur (strategy1 Ahistory Bhistory) (strategy2 Bhistory Ahistory) (+ Awin (get GameMatrix :DC)) (+ Bwin (get GameMatrix :CD)) (- n 1)))
))))


(defn Do-All-Combinations [n]
   (do
    (println "PlayerA: all-defect   PlayerB: all-cooperate")
    (compete-n-times all-defect all-cooperate n)(println "")
     (println "PlayerA: all-defect   PlayerB: random")
    (compete-n-times all-defect random n)(println "")
     (println "PlayerA: all-defect   PlayerB: tit-for-tat")
    (compete-n-times all-defect tit-for-tat n)(println "")
     (println "PlayerA: all-cooperate   PlayerB: random")
    (compete-n-times all-cooperate random n)(println "")
     (println "PlayerA: all-cooperate   PlayerB: tit-for-tat")
    (compete-n-times all-cooperate tit-for-tat n)(println "")
     (println "PlayerA: random   PlayerB: tit-for-tat")
    (compete-n-times random tit-for-tat n)(println "")(println "")(println "")
     (println "Extra credit:")
     (println "PlayerA: tit-for-two-tats    PlayerB: all-cooperate")
    (compete-n-times tit-for-two-tats all-cooperate n)(println "")
      (println "PlayerA: tit-for-two-tats    PlayerB: all-defect")
    (compete-n-times tit-for-two-tats all-defect n)(println "")
      (println "PlayerA: tit-for-two-tats    PlayerB: random")
    (compete-n-times tit-for-two-tats random n)(println "")
      (println "PlayerA: tit-for-two-tats    PlayerB: tit-for-tat")
    (compete-n-times tit-for-two-tats tit-for-tat n)

  ))

(Do-All-Combinations 100)
