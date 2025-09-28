class Question2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Question2 t1 = new Question2();
        t1.start();
    }
}
