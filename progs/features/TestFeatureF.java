class TestFeatureF {
    public static void main(String[] a) {
	if (new Test().f()) {} else {}
    }
}

class Test {

    public boolean f() {
	int result;
	int count;
	boolean done;
	result = 0;
	count = 1;
	while (count < 11 || this.g(result)) {
	    result = result + count;
	    count = count + 1;
	}
	return false;
    }
    
    public boolean g(int n) {
        System.out.println(n);
        return false;
    }

}

