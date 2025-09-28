public class Question_1 {
    private String data;
    private int number;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number >= 0) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Question_1 example = new Question_1();
        example.setData("Hello");
        example.setNumber(42);

        System.out.println("Data: " + example.getData());
        System.out.println("Number: " + example.getNumber());
    }
}
