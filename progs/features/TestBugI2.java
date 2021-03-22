class Main {
    public static void main(String[] a) {
	System.out.println(new TestBugI2().f());
    }
}

class TestBugI2 {

    public int f() {
	int result;
	int x;
	result = 0;
	x = 1;
	while (x < 11) {
	    result = result + x;
	}
	return result;
    }
}
