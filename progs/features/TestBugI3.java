class Main {
    public static void main(String[] args) {
	     System.out.println(new TestBugI3().f());
    }
}

class TestBugI3 {

  // Test to see if x gets modified. If x remains as 0,
  // then x isn't being modified.

  public int f() {
	int x;
  x++;
  x++;
  x++;
  x++;

	return x; // Returns the value of x.
  }
}
