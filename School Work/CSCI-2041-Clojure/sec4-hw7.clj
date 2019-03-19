(comment

  Nathan Comer
  ID: 5119060

 Link to the game: http://quil.info/sketches/show/-KGZBePkbq8CSbS19fK1

 How to play:
  -Use the arrow keys to move your ball (neon green ball).
  -This is a level based game, pass levels by being the last non-red ball.
  -You can freely pass through blue balls, if you come in contact with a red ball you will lose the game.
  -Levels will continously get more difficult.
  -If you go off the canvas you will be teleported to the center, you can use this strategically.

 Cheat:
  -Pressing the "L" key will automatically take you to the next level

 Note:
  -levels above 10 may start to lag
  -frame-rate can be reduced to decrease lag (currently set at 40)
)

(ns circles.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))


;;; Nathan Comer

;;; Circles Game Basic Setup
;;; CSCI 2041 Homework #7
;;; Spring 2016


;;; Constants
(def speed 2)                          ;maximm speed circles move
(def score 0)
(def level 1)
(def end "")

;---------------------------------------------------------------------
; Setup
;---------------------------------------------------------------------

(defn make-circle
  "Creates a circle with a random color and set speed and heading."
   [x y]

  (let [angle (rand q/TWO-PI)          ;random angle
        cur-speed (+ (rand speed) 1)]  ;random speed up to our constant
       {:x x                           ;set this circle's x
    	:y y                           ;set this circle's y
        :size (+ (/ 100 (+ level (q/log (* 10 level)))) (rand 10))         ;set random diameter
    	:color 170              ;make this colorful
    	:speed cur-speed               ;set this circle's speed
    	:heading angle}                ;set this circle's heading
    ))                                 ;returns circle

(defn make-player
  "Creates player"
   []
       {:x 250                           ;set this circle's x
    	:y 450                           ;set this circle's y
        :size 20         ;set random diameter
    	:color 100              ;make this colorful
    	:speed 3               ;set this circle's speed
    	:heading 1.57}                ;set this circle's heading
    )

(defn make-enemy
  "Creates first enemy"
   []
       {:x 250                           ;set this circle's x
    	:y 50                           ;set this circle's y
        :size 20         ;set random diameter
    	:color 255              ;make this colorful
    	:speed 3               ;set this circle's speed
    	:heading 4.7}                ;set this circle's heading
    )

(defn more-circles [n s]
    (loop [m '() n n]
    (if (> n 0) (recur (concat m [(make-circle (rand s) (rand s))]) (- n 1))
      m)))

(defn setup
  "Set up a sketch and return initial state."
  []
  (q/frame-rate 40)                    ;frequency update and draw functions
  (q/color-mode :hsb)                  ;how we represent colors
  (let [size (q/width)
        n (+ 16 (* level 4))

        bg 0]
       (q/background bg)               ;nice light grey color for the bg
       ;; need to make n circles of random sizes
       ;; here we make only one circle in a list
       {:circles (concat (more-circles n size) (list (make-enemy)))
        :player (make-player)
        :running? true                 ;so we can pause and unpause in update
        :n n                           ;how many circles
        :size size                     ;how big is the sketch
        :bg bg                         ;we might want to change this later
        }))

;---------------------------------------------------------------------
; Update functions
;---------------------------------------------------------------------

(defn move-circle
  "Moves a circle according to its speed and heading"
  [c state]
     (merge {:x (+ (get c :x) (* (get c :speed) (q/cos (get c :heading))))
                       :y (+ (get c :y) (* (get c :speed) (q/sin (get c :heading))))}
                      (bounce-back c (get c :size))))

(defn bounce-back [c size]
        (cond (>= (get c :x) 500) {:heading (if (> (get c :heading) 3.1415)(- 15.7075 (get c :heading)) (- 3.1415 (get c :heading)))
                                   :x (- (get c :x) (* (get c :speed) (q/cos (get c (- 180 (get c :heading)))) 2))}
              (>= (get c :y) 500) {:heading (- 6.2830 (get c :heading))
                                   :y (- (get c :y) (* (get c :speed) (q/sin (get c :heading)) 2))}
              (<= (get c :x) 0) {:heading (q/atan (/ (q/sin (get c :heading)) (- (q/cos (get c :heading)))))
                               	   :x (- (get c :x) (* (get c :speed) (q/cos (get c :heading)) 2))}
              (<= (get c :y) 0) {:heading (- 6.2830 (get c :heading))
                                   :y (- (get c :y) (* (get c :speed) (q/sin (get c :heading)) 2))}))

(defn collision-detection
  "Detects collisions between balls"
  [c circles state]
    (cond
      (= (get c :color) 170)
      	(loop [n 0]
      		(cond
        		(>= n (count circles)) (merge c (move-circle c state))
              	(= (get (nth circles n) :color) 170) (recur (+ n 1))
              	(and (< (- (q/sqrt (+ (q/sq (q/abs (- (get c :x) (get (nth circles n) :x))))
             	       			   (q/sq (q/abs (- (get c :y) (get (nth circles n) :y))))))
						(/ (+ (get c :size)
               	  			  (get (nth circles n) :size))
              	   			2))
                        0)
                     (not (and (= (get c :x)
                                  (get (nth circles n) :x))
                          	   (= (get c :y)
                                  (get (nth circles n) :y)))))
              	       	(do (def score (+ score 1))
                              (merge c {:color 255} (move-circle c state)))
              	:else (recur (+ n 1))))
      	:else  (merge c (move-circle c state))))

(defn player-collision [p circles state]
  (cond (or (< 500 (get p :x)) (< 500 (get p :y)) (> 0 (get p :x)) (> 0 (get p :y)))
        	(merge (:player state) {:x 250 :y 250})
    	(empty? (filter (fn [c] (and (< (q/sqrt (+ (q/sq (q/abs (- (get c :x) (get p :x))))
             	       		(q/sq (q/abs (- (get c :y) (get p :y))))))
						(/ (+ (get c :size)
               	  			  (get p :size))
              	   			2)) (= (get c :color) 255))) circles))
  			(get state :player)
        :else (do (def end "Play again? y/n") (merge (:player state) {:color 255}))))

(defn update-circles
  "Moves each circle and returns updated vector of circles."
  [circles state]
    (map (fn [c] (collision-detection c circles state)) circles))

(defn update-state
  "Updates sketch state. If it is paused, then the state is returned unmodified."
  [state]
  (cond
    (empty? (filter (fn [c] (= 170 (get c :color))) (:circles state))) (next-level)
   	(= 255 (get (:player state) :color)) (assoc state :running false)
    (:running? state)
      ;add some movement and update functions so the next line moves circles
      (assoc state :circles (update-circles (:circles state) state)
        		   :player (player-collision (:player state) (:circles state) state))
      :else state))

(defn reset []
    (do
      (def level 1)
      (def score 0)
      (def end "")
      (setup)))

(defn next-level []
  (do
     (def level (+ level 1))
     (setup)))

(defn clear []
  (setup)
  nil)

;---------------------------------------------------------------------
; Draw functions
;---------------------------------------------------------------------

(defn draw-circle
  "Draws an individual circle with correct color, location, and size."
  [c]
  (q/fill (:color c) 255 255)
  (q/ellipse (:x c) (:y c) (:size c) (:size c)))

(defn draw-player [p]
  (q/fill (:color p) 255 255)
  (q/ellipse (:x p) (:y p) (:size p) (:size p)))

(defn draw-end [state]
  (q/background 0 0 0 0)
   (q/exit))

(defn draw-state
  "Draws the sketch state."
  [state]
  (q/background (:bg state))                    ;update the background
  (q/stroke 1)                                  ;how wide should the lines be
  (dorun (map draw-circle (:circles state)))    ;map is lazy
  (dorun (draw-player (:player state)))
  (q/text (str "Score: " score) 10 20)
  (q/text (str "Level: " level) 10 40)
  (q/text (str end) 200 50)
  (q/text "Use the arrow keys to move your ball." 287 475)
  (q/text "Pass each level by being the last non-red ball." 240 487)
  (q/fill 0)
  )



;---------------------------------------------------------------------
; User interaction functions
;---------------------------------------------------------------------

(defn mouse-clicked
  "Changes background color to different shades of grey."
  [state event]
  (update-in state [:bg] (fn [n] 0)))

(defn key-pressed
  "Process key event.  p will pause/unpause everything."
  [state event]
  (condp = (:key event)
    :right (update-in state [:player] assoc :x (+ 8 (get (get state :player) :x)))
    :left (update-in state [:player] assoc :x (- (get (get state :player) :x) 8))
    :down (update-in state [:player] assoc :y (+ 8 (get (get state :player) :y)))
    :up (update-in state [:player] assoc :y (- (get (get state :player) :y) 8))
    :p (update-in state [:running?] not)
    :y (reset)
    :l (clear)
    :n (draw-end state)
    state))

(q/defsketch circles
    :host "host"
    :size [500 500]                ;we need a square canvas
    :setup setup                   ;getting things started, setting initial state
    :update update-state           ;the function to update the state
    :draw draw-state               ;the necessary draw function
    :mouse-clicked mouse-clicked   ;this is our mouse click event
    :key-pressed key-pressed       ;this is our keyboard input event
    :middleware [m/fun-mode])      ;this gives us the ability to have state

