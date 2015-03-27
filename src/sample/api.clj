(ns sample.api
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            sample.components.handler))

(defapi api
  {:format {:formats [:json]}}

  (swagger-ui)
  (swagger-docs
    :title "Sample API")

  (swaggered "system"
    :description "system apis"
    (context "/system" []
      (GET* "/ping" []
        :components [env]
        (ok {:ok true
             :port (-> env :config :http :port)})))))
