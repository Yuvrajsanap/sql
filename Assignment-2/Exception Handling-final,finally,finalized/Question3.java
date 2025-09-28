//finalize
public class Question3 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource = null;
        System.gc();
    }
}

class Resource {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Cleanup operations.");
        super.finalize();
    }
}
