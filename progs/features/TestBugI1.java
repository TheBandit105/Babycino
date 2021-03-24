class Main {
    public static void main(String[] args) {
	     System.out.println(new TestBugI1().f());
    }
}

class TestBugI1 {

  // Test to see if compiler prevents bug that allows the
  // incrementation of booleans. If compiler works correctly,
  // should return type errors.

  public int f() {
	boolean x;
	x++;

	return x; // Returns value of x.
  }
}
