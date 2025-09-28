class Question4 extends Thread {
    private int sleepTime;

    public Question4(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            Thread.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName() + " slept for " + sleepTime + " ms");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Question4 t1 = new Question4(500); // 0.5 second
        Question4 t2 = new Question4(1000); // 1 second
        Question4 t3 = new Question4(1500); // 1.5 seconds
        t1.start();
        t2.start();
        t3.start();
    }
}
