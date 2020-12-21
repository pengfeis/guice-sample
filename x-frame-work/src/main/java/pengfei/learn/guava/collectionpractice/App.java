package pengfei.learn.guava.collectionpractice;

public class App {

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {





    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] a = null;
        for (int i=0; i<nums.length; i++) {
            for(int j=1; j<nums.length; j++) {
                if ((target - nums[i]) == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return a;
    }

    public static void changeStr(Person2 person) {
//        person.setName("b");
        person = new Person2("b");
    }

}

class Person2 {
    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

class Color {
    public Color() {
    }
}