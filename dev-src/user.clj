(ns user
  (:require [reloaded.repl :refer [system init start stop go reset]]))

(defn set-opts [& {:keys [system opts]
                   :or {system 'sample.system/base-system}}]
  (reloaded.repl/set-init!
    (fn []
      (require (symbol (namespace system)))
      ((resolve system) (or opts {})))))

(set-opts)
