public class GCTest {
	public static void main(String[] args) throws InterruptedException {
		A a = new A("white");
		a = null;
 
		Runtime.getRuntime().gc();
	}
}
 
class A {
	private String color;
 
	public A(String color) {
		this.color = color;
	}
 
	@Override
	public void finalize() {
		System.out.println(this.color + " cleaned");
	}
}
