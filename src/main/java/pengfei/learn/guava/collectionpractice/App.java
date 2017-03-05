package pengfei.learn.guava.collectionpractice;

public class App {
    public static void main(String[] args) {

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

    public static void changeStr(Person person) {
//        person.setName("b");
        person = new Person("b");
    }

}

class Person {
    public Person(String name) {
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