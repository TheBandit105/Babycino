class TestFeatureB {
    public static void main(String[] a) {
	System.out.println(new Test().f());
    }
}

class Test {

    public int f(){
	int result;
	int count;
	boolean done;
	result = 0;
	count = 1;
	done = false;
	while (done != true) {
	    result = result + count;
	    done = !(count != 10);
	    count = count + 1;
	}
	return result;
    }

}

