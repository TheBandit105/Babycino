class Main {
  public static void main(String[] args) {
	       System.out.println(new TestBugD2().f());
    }
}

class TestBugD2 {

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

  return 0;
  }
}
