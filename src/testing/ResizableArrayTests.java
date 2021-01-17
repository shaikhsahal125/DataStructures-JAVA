package testing;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import interfaces.IResizableArray;
import implementations.ResizableArray;
import testing.ResizableArrayTests;

public class ResizableArrayTests {
	private static StringBuilder report = new StringBuilder();
	@Rule 
	public TestWatcher watchman = new TestWatcher() {
	    @Override
	    protected void failed(Throwable t, Description description) {
	        report.append("  FAILURE: ").append(description.getMethodName()).append("\n");
	    }
	    @Override
	    protected void succeeded(Description description) {
	        report.append("  Success: ").append(description.getMethodName()).append("\n");
	    }
	};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		report.append("\nTesting: ").append(ResizableArrayTests.class.getSimpleName()).append("\n");
	}
	@AfterClass
	public static void tearDownClass() {
	    System.out.println(report.toString());
	}
	@Test
	public void dumbTest() {
		IResizableArray<Integer> resizableArray = new ResizableArray<>();
		assertEquals(0, resizableArray.getSize());
		System.out.println("passed1");
		resizableArray.resize(8);
		assertEquals(8, resizableArray.getSize());
		System.out.println("passed2");
		for (int i = 0; i < resizableArray.getSize(); i++) {
			resizableArray.set(i, i * 2 + 1);
		}
		assertEquals((int) 11, (int) resizableArray.get(5));
		System.out.println("passed3");
		resizableArray.resize(12);
		assertEquals(12, resizableArray.getSize());
		System.out.println("passed4");
		resizableArray.set(10, 42);
		assertEquals(Integer.valueOf(42), resizableArray.get(10));
		System.out.println("passed5");
		resizableArray.resize(16, 123);
		assertEquals(16, resizableArray.getSize());
		System.out.println("passed6");
		assertEquals(Integer.valueOf(123), resizableArray.get(15));
		System.out.println("passed7");
	}

}
