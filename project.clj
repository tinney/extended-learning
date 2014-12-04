(defproject my-proj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.0.1"]
                 [compojure "1.0.1"]
                 [enlive "1.0.0"]
                 ]
  :main ^:skip-aot my-proj.app
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
