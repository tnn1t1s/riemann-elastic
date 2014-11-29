# Riemann Elastic

Riemann Elastic is a Riemann plugin for indexing Riemann events in Elastic Search.

## Installation

First, you'll need to build the plugin using lein

```clj
$ lein uberjar
```

This will create a plugin jar named `elastic-riemann-0.1.0-SNAPSHOT-standalone.jar`

Now, you can start Riemann using the following command. 

```
java -server -cp ${RIEMANN_HOME}/lib/riemann.jar:${RIEMANN_ELASTIC}/target/elastic-riemann-0.1.0-SNAPSHOT-standalone.jar clojure.main -m riemann.bin ${RIEMANN_HOME}/etc/riemann.config
```

This will start Riemann with the plugin available. You can load the plugin in riemann.config with the following line:

```clj
(require '[riemann.elastic :as elastic])
```

You can start pushing events to elastic search with the elastic/es-index function. Here's an snippet of a Riemann config that does the job.

```clk
(def myindex (default :ttl 300 (index)))

(def elastic-url "http://localhost:9200")
(def elastic-conn (when (seq elastic-url) (elastic/es-connect elastic-url)))

(def standard-sink
  (let [sinks (if elastic-conn
                [myindex (async-queue! :elastic-search
                                      {:queue-size 10000}
                                      (batch 200 10 (elastic/es-index "riemann-elastic")))]
                [myindex])]
    (fn [e]
      (call-rescue e sinks))))
      
; send everything to stdout and standard-sink e.g. elastic and the index.
(streams prn standard-sink)
```

## Elastic and Kibana
With the riemann.config above, events should be persisted to Elastic Search. You can see the last 10 events indexed with the following curl command.

```
$ curl http://localhost:9200/_search?query=*
```

If that works, Kibana will work too. You can find Kibana here:
     - http://www.elasticsearch.org/overview/kibana/
# Credit
This project started as a fork of Kiries.
    - https://github.com/threatgrid/kiries
    
Kiries bundles Riemann, Elastic Search and Kibana in single repository. It's awesome and really useful but proved difficult to integrate in my environment. I ripped out the Riemann Elastic bits and made it into a Riemann plugin.

