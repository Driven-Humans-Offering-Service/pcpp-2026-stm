package exercises01;

class AddNumbers {
    public static void main(String[] args) {
        long start, spent;
        start = System.nanoTime();

        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        spent = System.nanoTime() - start;
        System.out.println("Time spent: " + spent);
    }
}
