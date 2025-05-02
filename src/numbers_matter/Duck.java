public class Duck {
    private int size;

    public static void main(String[] args) {
        System.out.println("Size of the duck is " + getSize());
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}