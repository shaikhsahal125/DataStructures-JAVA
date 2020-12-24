package ownClass;

public class MySubClass extends MyClass implements java.lang.Comparable<MySubClass> {
	public int compareTo(MySubClass that) {
		return this.hashCode() - that.hashCode();
	}

}
