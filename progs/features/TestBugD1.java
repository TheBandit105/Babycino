class Main {
  public static void main(String[] args) {
	       System.out.println(new TestBugD1().f());
    }
}

class TestBugD1 {

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

	return 0;
  }
}
