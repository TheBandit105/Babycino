class Main {
  public static void main(String[] args) {
	       System.out.println(new TestBugD1().f());
    }
}

class TestBugD1 {

  // Test to see if compiler prevents bug that allows comparisons of booleans.
  // If compiler works correctly, should return type errors.

  public int f() {
	boolean x;
	boolean y;

  x = true;
  y = false;

  if (x >= y) {
      System.out.println(1);
  } else {
      System.out.println(0);
	}

  // This 0 printed has nothing to do with the compiler working correctly.
  // It's an added feature to make sure the test bug is being compiled.
	return 0;
  }
}
