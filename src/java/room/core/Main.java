package room.core;

import clojure.lang.RT;
import clojure.lang.Symbol;

import org.robovm.apple.foundation.*;
import org.robovm.apple.uikit.*;

public class Main extends UIApplicationDelegateAdapter {
	public boolean didFinishLaunching(UIApplication app, UIApplicationLaunchOptions opts) {
		RT.var("clojure.core", "require").invoke(Symbol.intern("room.core"));
		RT.var("room.core", "init").invoke();
		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, Main.class);
		pool.close();
	}
}
