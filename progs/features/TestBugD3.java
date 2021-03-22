class Main {
  public static void main(String[] args) {
		     System.out.println(new TestBugD3().f());
	  }
}

class TestBugD3 {

	public int f() {
	int x;
	int y;
	int z;

	x = 3;
	y = 3;
	z = 2;

	if (x >= z && x >= y) {
			System.out.println(1);
	} else {
			System.out.println(0);
	}

	return 0;
	}
}
