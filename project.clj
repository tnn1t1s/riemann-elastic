(defproject org.tinnitus.dl/elastic-riemann "0.1.0-SNAPSHOT"
  :description "A plugin for using ElasticSearch and Kibana with Riemann"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.1"]
                 [cheshire "5.3.1"]
                 [clj-logging-config "1.9.6"]
                 [riemann "0.2.6"]
                 [clojurewerkz/elastisch "1.2.0"]
                 [org.elasticsearch/elasticsearch "0.90.3"]
                 ]
  :main elastic-riemann.core)

