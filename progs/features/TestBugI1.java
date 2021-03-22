class Main {
    public static void main(String[] a) {
	System.out.println(new TestBugI1().f());
    }
}

class TestBugI1 {

  public int f() {
	boolean result;
	boolean count;
	result = true;
	count = false;
	while (count < result) {
	    result = result + count;
	    count++;
	}
	return result;
    }
}
