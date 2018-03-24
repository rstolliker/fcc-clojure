# random-quote-generator

A single-page app which shows you a new random quote by clicking a button.

Built for a Free Code Camp challenge, but written using ClojureScript instead of plain JavaScript.

Technologies used:
* ClojureScript
* Reagent
* HTML
* Bootstrap

I do not own the background image, it is taken from Wikipedia.

## Development Mode

### Start Cider from Emacs:

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl "(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build

```
lein clean
lein cljsbuild once min
```
