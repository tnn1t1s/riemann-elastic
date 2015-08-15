(defproject org.tinnitus.dl/elastic-riemann "0.1.1-SNAPSHOT"
  :description "A plugin for using ElasticSearch and Kibana with Riemann"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.1"]
                 [cheshire "5.3.1"]
                 [clj-logging-config "1.9.6"]
                 [riemann "0.2.10" :exclusions [joda-time org.slf4j/slf4j-log4j12]]
                 [clojurewerkz/elastisch "1.2.0"]
                 [org.elasticsearch/elasticsearch "0.90.3"]
                 ]
  :main elastic-riemann.core)

