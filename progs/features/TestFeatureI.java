class TestFeatureI {
    public static void main(String[] a) {
	System.out.println(new Test().f());
    }
}

class Test {

    public int f() {
	int result;
	int count;
	result = 0;
	count = 1;
	while (count < 11) {
	    result = result + count;
	    count++;
	}
	return result;
    }
}
