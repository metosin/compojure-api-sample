(ns sample.main
  (:gen-class))

(defn -main [& _]
  (require 'sample.system)
  ((resolve 'sample.system/start-base-system) {}))
