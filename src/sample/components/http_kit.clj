(ns sample.components.http-kit
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as component]
            [schema.core :as s]))

(defrecord Http-kit [env handler]
  component/Lifecycle
  (start [component]
    (let [config (get-in env [:config :http])]
      (println (str "Starting http-kit on port " (:port config)))
      (assoc component :http-kit (run-server (:handler handler) config))))
  (stop [{:keys [http-kit] :as component}]
    (when http-kit (http-kit))
    (assoc component :http-kit nil)))

(defn start-http-kit []
  (Http-kit. nil nil))
