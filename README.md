# Riemann Elastic

Riemann Elastic is a Riemann plugin for indexing Riemann events in Elastic Search.

## Installation

First, you'll need to build the plugin using lein

```clj
$ lein uberjar
```

This will create a plugin jar named `elastic-riemann-0.1.0-SNAPSHOT-standalone.jar`

Now, you can update your riemann start script to include this jar in the -cp option. This will start Riemann with the plugin available. You can load the plugin in riemann.config with the following line:

```clj
(require '[riemann.elastic :as elastic])
```


