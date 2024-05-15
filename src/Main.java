class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i);
            Student value = new Student("Student" + i);
            table.put(key, value);
        }

        printBucketSizes(table);
    }

    private static void printBucketSizes(MyHashTable<MyTestingClass, Student> table) {
        int[] bucketSizes = new int[table.getM()];
        for (int i = 0; i < table.getM(); i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, Student> currentNode = table.getChainArray()[i];
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }
            bucketSizes[i] = count;
        }

        System.out.println("Number of elements in each bucket:");
        for (int i = 0; i < table.getM(); i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i]);
        }
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }
}