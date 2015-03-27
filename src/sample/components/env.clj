(ns sample.components.env
  (:require [com.stuartsierra.component :as component]))

(defrecord Env [config]
  component/Lifecycle
  (start [this]
    ;; reload!
    (assoc this :config config))
  (stop [this]
    (assoc this :config nil)))

(defn create-env [config]
  (Env. config))
