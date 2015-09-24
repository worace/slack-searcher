## Slack Searcher

Web interface to searching logs aggregated by
[slack slurper](https://github.com/worace/slack-slurper).

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## Production

Currently deploying by scp-ing the jar up to the box and starting it
with `init.d`. Here is the init conf:

```
description "Starts the slack searcher compojure server"
author "Horace Williams"
start on runlevel [2345]
stop on shutdown
exec java -jar /root/slack-searcher.jar
```

__Building the jar:__

```
lein ring uberjar
```
