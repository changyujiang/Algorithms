package designPattern.singleton;

// Singleton is simply a class that is instantiated exactly once in JVM.

// HungrySingleton is kind of 
// EAGER initialization.
public class HungrySingleton {
	private static final HungrySingleton hungrySingleton = new HungrySingleton();
	
	private HungrySingleton (){}
	
	public static HungrySingleton getInstance(){
		return hungrySingleton;
	}
}
