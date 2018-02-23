package designPattern.singleton;

// A singleton is simply a class that is instantiated exactly once in JVM;
// singleton typically represent a system component that is intrinsically unique,
// such as the window manage and file system.

// HungrySingleton's eager initialization brings some problems.
// Instance is initialized when class loaded.

// We use lazy initialization. initialize the instance when needed.
public class LazySingleton {
	private static LazySingleton lazySingleton;
	
	private LazySingleton(){};
	
	// static factory method
	public static LazySingleton getInstance() {
		if (lazySingleton != null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
