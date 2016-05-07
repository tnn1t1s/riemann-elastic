(defproject org.tinnitus.dl/elastic-riemann "0.1.1-SNAPSHOT"
  :description "A plugin for using ElasticSearch and Kibana with Riemann"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.3.5"]
                 [cheshire "5.6.1"]
                 [clj-logging-config "1.9.12"]
                 [riemann "0.2.11" :exclusions [joda-time org.slf4j/slf4j-log4j12]]
                 [clojurewerkz/elastisch "1.2.0"]
                 [org.elasticsearch/elasticsearch "2.3.2"]
                 ]
  :main elastic-riemann.core)

