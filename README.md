# Riemann Elastic

Riemann Elastic is a Riemann plugin for indexing Riemann events in Elastic Search.

## Installation

First, you'll need to build the plugin using lein

```clj
$ lein uberjar
```

This will create a plugin jar named `elastic-riemann-0.1.0-SNAPSHOT-standalone.jar`

Now, you can start Riemann using the following command. 

java -server -cp ${RIEMANN_HOME}/lib/riemann.jar:${RIEMANN_ELASTIC}/target/elastic-riemann-0.1.0-SNAPSHOT-standalone.jar clojure.main -m riemann.bin ${RIEMANN_HOME}/etc/riemann.config


This will start Riemann with the plugin available. You can load the plugin in riemann.config with the following line:

```clj
(require '[riemann.elastic :as elastic])
```


