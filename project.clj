(defproject room "0.0.1-SNAPSHOT"
  :description "turn any device into a window to a virtual room"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.7" "-source" "1.7" "-Xlint:-options"]
  :ios {:robovm-opts ["-forcelinkclasses" "room.**:clojure.**:org.robovm.apple.**"
                      "-frameworks" "UIKit:OpenGLES:QuartzCore:CoreGraphics:OpenAL:AudioToolbox:AVFoundation"
                      "-resources" "resources/**"]}
  :aot :all
  :main room.core.Main)
