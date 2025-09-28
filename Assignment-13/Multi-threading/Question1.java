class Question1 extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        Question1 t1 = new Question1();
        t1.start();
    }
}
