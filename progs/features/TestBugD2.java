class Main {
  public static void main(String[] args) {
	       System.out.println(new TestBugD2().f());
    }
}

class TestBugD2 {

  // Test to see if compiler prevents bug that allows the statement, x = y,
  //  to return false. If compiler works correctly, should return the value of 1,
  //  indicating that x = y is true.

  public int f() {
	int x;
	int y;

	x = 1;
	y = 1;

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
