(ns sample.system
  (:require [com.stuartsierra.component :as component :refer [using]]
            [sample.components.http-kit :refer [start-http-kit]]
            [sample.components.env :refer [create-env]]
            [sample.components.handler :refer [create-handler]]))

(defn base-system [& [config]]
  (component/system-map
    :env           (create-env config)
    :handler       (using (create-handler 'sample.api/api) [:env])
    :http-server   (using (start-http-kit) [:handler :env])))

(defn start-base-system [& [opts]]
  (component/start (base-system opts)))
