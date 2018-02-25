package designPattern.singleton;

public class LazySingletonThreadSafe {
	private static LazySingletonThreadSafe lazySingletonThreadSafe;
	
	private LazySingletonThreadSafe(){
		
	}
	
	public synchronized LazySingletonThreadSafe getInstance() {
		if (lazySingletonThreadSafe == null) {
			lazySingletonThreadSafe = new LazySingletonThreadSafe();
		} 
		return lazySingletonThreadSafe;
	}
}
