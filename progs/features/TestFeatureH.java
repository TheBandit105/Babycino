class TestFeatureH {
    public static void main(String[] a) {
	System.out.println(new Test().f());
    }
}

class Test {

    public int f() {
	int result;
	int count;
	boolean done;
	result = 0;
	count = 1;
	done = true;
	do {
	    result = result + count;
	    count = count + 1;
	    done = (10 < count);
	} while (!done);
	return result;
    }

}

