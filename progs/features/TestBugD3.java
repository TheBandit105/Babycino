class Main {
  public static void main(String[] args) {
		     System.out.println(new TestBugD3().f());
	  }
}

class TestBugD3 {

  // Test to see if compiler recognises that >= has higher precedence than &&.
  // If compiler works correctly, should return the value of 1, indicating that
  // the compiler recognises >= being of higher precedence than &&. If 0 is
  // returned, suggests >= has lower precedence than &&, which tells us that
  // the compiler has a bug in the order of precedences.

	public int f() {
  int w;
	int x;
	int y;
	int z;

  w = 5;
  x = 4;
	y = 3;
	z = 2;

	if (x >= y && w >= z) {
			System.out.println(1);
	} else {
			System.out.println(0);
	}

  // This 0 printed has nothing to do with the compiler working correctly.
  // It's an added feature to make sure the test bug is being compiled.
	return 0;
	}
}
