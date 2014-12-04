# Tiny URL Generator

Clojure based tiny-url generator, using enlive templates.  

## Installation

Install clojure and java, clone the repo and run in the repl. 

## Usage

    $ lein repl

### Starts the server on localhost:8081
    $ => (def server (jetty/run-jetty #'app {:port 8081 :join? false}))

### Reloads the project after files change
    $ => (require 'my-proj.app :reload-all) ;reloads the project
