(defproject demo45 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"] 
                 [org.clojure/java.jdbc "0.7.12"] 
                 [org.postgresql/postgresql "42.3.8"]
                 [com.zaxxer/HikariCP "5.0.1"] 
                 [ch.qos.logback/logback-classic "1.2.11"]
                 [com.mchange/c3p0 "0.9.5.2"] 
                 ]
  :main ^:skip-aot demo45.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
