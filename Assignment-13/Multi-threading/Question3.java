class Question3 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        Question3 t1 = new Question3();
        Question3 t2 = new Question3();
        t1.start();
        t2.start();
    }
}
