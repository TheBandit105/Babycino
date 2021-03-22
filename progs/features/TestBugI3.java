class Main {
    public static void main(String[] a) {
	System.out.println(new TestBugI3().f());
    }
}

class TestBugI3 {

  public int f() {
	int result;
	int count;
	result = 0;
	while (count < 11) {
	    result = result + count;
	    count++;
	}
	return result;

  }
}
