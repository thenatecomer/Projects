(use 'clojure.java.io)
(def c (atom 0))

(def fileLocation "NASA_access_log_Jul95_short") (comment <=======Update file location here if neccesary)

(defn count-IP []
	(with-open [rdr (reader fileLocation)]
  		(do (reset! c 0)
        (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"^(\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b)" line)))
            (swap! c inc)))
    @c)))

(defn find-private-IP []
  (with-open [rdr (reader fileLocation)]
  	 (let [col (atom '())]
      (do (reset! c 0)
        (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"^(((127\.)|((10\.)|(192\.(168\.|88\.99\.))))\d{1,3})" line)))
            (swap! col concat (list line))))
    @col))))

(defn count-request-on-dates []
  (with-open [rdr (reader fileLocation)]
  	 (do (reset! c 0)
        (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"((05|04)/Jul/1995:\d{2}:\d{2}:\d{2})" line)))
            (swap! c inc)))
    @c)))

(def previousHost [])

(defn previousHosts [x]
  (loop [t previousHost]
    (cond (empty? t) (do (def previousHost (concat previousHost [x])) nil)
          (= x (first t)) true
          :else (recur (rest t)))))

(defn count-hosts []
  (with-open [rdr (reader fileLocation)]
  		(do (def previousHost [])
      (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"(05/Jul/1995:22:[0-2]{1}[0-9]{1}:\d{2})" line)))
              (previousHosts (first (first (re-seq #"(^[^\s]+)" line)))))))
    previousHost))

(defn find-server-error []
  (with-open [rdr (reader fileLocation)]
  	  (let [col (atom '())]
        (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"(\s5\d{2}\s)" line)))
            (swap! col concat (list line))))
  @col)))

(defn count-redirect []
  (with-open [rdr (reader fileLocation)]
  	  (do (reset! c 0)
        (doseq [line (line-seq rdr)]
         	(if
            (not (empty? (re-seq #"(\s3\d{2}\s)" line)))
            (swap! c inc)))
  @c)))

(defn count-morethan50000 []
  (with-open [rdr (reader fileLocation)]
  	 (do (reset! c 0)
        (doseq [line (line-seq rdr)]
         	(if (string? (first (re-find #"((\d+)$)" line)))
            (if (> (read-string (first (re-find  #"((\d+)$)" line))) 50000)
          (swap! c inc))))
    @c)))

