package com.example.tunglv27javafis;


public class HelloApplication  {
    private static StringBuilder stringBuilder = new StringBuilder("abc");
    private static StringBuffer stringBuffer = new StringBuffer("abc");
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new AppendThread(i);
            threads[i].start();
        }

        // Đợi tất cả các luồng hoàn thành
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("StringBuilder result: " + stringBuilder.length());
        System.out.println("StringBuffer result: " + stringBuffer.length());


//        clone object
        Address originalAddress = new Address("123 Main St", "Cityville");
        Person originalPerson = new Person("Alice", 30, originalAddress);

//         Thực hiện deep copy cho đối tượng Person
//        Person clonedPerson = SerializationUtils.clone(originalPerson);

//        // Kiểm tra sự khác biệt giữa originalPerson và clonedPerson
//        System.out.println("Original: " + originalPerson);
//        System.out.println("Cloned: " + clonedPerson);
//
//        // Kiểm tra sự khác biệt giữa đối tượng Address trong originalPerson và clonedPerson
//        System.out.println("Original Address: " + originalPerson.getAddress());
//        System.out.println("Cloned Address: " + clonedPerson.getAddress());
    }
    static class AppendThread extends Thread {
        private int threadId;

        public AppendThread(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("123");
                stringBuffer.append("123");
            }
        }
    }
}