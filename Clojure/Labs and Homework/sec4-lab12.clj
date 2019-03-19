(use 'clojure.java.io)

(defn printfromfile []
	(with-open [rdr (reader "tmpdata.txt")]
  		(doseq [line (line-seq rdr)]
         	(prn line))))

(defn firstentry []
	(with-open [rdr (reader "tmpdata.txt")]
  		(doseq [line (line-seq rdr)]
         	(prn (re-seq #"^[^\s]+" line)))))

(defn endline []
	(with-open [rdr (reader "tmpdata.txt")]
  		(doseq [line (line-seq rdr)]
         	(prn (Integer/parseInt (first (re-seq #"\d+{1,6}$" line)))))))


		
