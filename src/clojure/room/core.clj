(ns room.core
  (:import [org.robovm.apple.coregraphics CGRect]
           [org.robovm.apple.uikit UIButton UIButtonType UIColor
            UIControl$OnTouchUpInsideListener UIControlState UIScreen UIWindow]))

(defn set-frame! [x frame]
  (.setFrame x frame))

(def set-title!
  (fn [args]
    (apply .setTitle args)))
      (.setTitle "Click me!" normal)

(defn set-title! [x title normal]
  (.setTitle x title normal))

(def window (atom nil))

(def bg-color
  (UIColor/lightGray))

(defn make-frame []
  (CGRect. 115 121 91 37))

(defn add-on-touch-up-inside-listener! [x listener]
  (.addOnTouchUpInsideListener x listener))

(defn make-window [button]
  (let [window (-> (UIScreen/getMainScreen)
                   .getBounds
                   UIWindow.)]
    (doto @window
      (.setBackgroundColor bg-color)
      (.addSubview button)
      .makeKeyAndVisible)
    window))

(defn make-touch-up-proxy []
  (let [click-count (atom 0)]
    (proxy [UIControl$OnTouchUpInsideListener] []
      (onTouchUpInside [control event]
        (let [label (str "Click #" (swap! click-count inc))]
          (.setTitle button label normal))))))

(defn make-button
  ([]
   (let [default-title "Click me!"]
     (make-button default-title)))
  ([title]
   (let [frame (make-frame)]
     (make-button frame title)))
  ([frame title]
   (let [proxy (make-proxy)]
     (make-button frame proxy title)))
  ([frame proxy title]
   (let [normal UIControlState/Normal]
     (doto (UIButton/create UIButtonType/RoundedRect)
       (set-frame! frame)
       (set-title! title normal)
       (add-on-touch-up-inside-listener! proxy)))))

(defn init
  []
  (-> (make-button)
      make-window
      (->> (reset! window)))
  (let [b (make-button)
        w (make-window b)]
    (reset! window w)))
