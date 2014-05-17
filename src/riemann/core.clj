(ns riemann.core
  (:use [clojure.java.shell :only [sh]] [clojure.string :only [split]]))

;; get list of modified files
(defn modified [] (split (:out (sh "git" "ls-files" "-m")) #"\n"))

;; t log --diff-filter=D --summary | grep delete



