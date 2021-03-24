class Main {
    public static void main(String[] args) {
	     System.out.println(new TestBugI2().f());
    }
}

class TestBugI2 {

  // Test to see if the code increments from a set value.
  // If x stays as 1, then compiler isn't incrementing.

  public int f() {
  int x;
  x = 1;

  while (x < 10) {
    x++;
  }

	return x; // Returns the value of x.
  }
}
