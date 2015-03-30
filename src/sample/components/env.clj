(ns sample.components.env
  (:require [com.stuartsierra.component :as component]))

(defrecord Env [config]
  component/Lifecycle
  (start [this]
    ;; reload for real from edn-file &/ properties
    (let [config (merge config {:http {:port 3000}})]
      (assoc this :config config)))
  (stop [this]
    (assoc this :config nil)))

(defn create-env [config]
  (Env. config))
