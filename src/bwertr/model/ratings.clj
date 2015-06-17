(ns bwertr.model.ratings)

(let [db (atom [])]
  (defn all []
    @db)
  (defn add! [new-rating]
    (swap! db conj new-rating))
  (defn average []
    (when-let [all-ratings (seq @db)]
      (int (Math/ceil (/ (reduce + all-ratings) (count all-ratings)))))))
