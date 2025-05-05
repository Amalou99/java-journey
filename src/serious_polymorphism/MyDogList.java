public class MyDogList {
    private Dog[] dogs = new Dog[5];
    private int nextIndex = 0;

    public void add(Dog dog) {
        if (nextIndex < dogs.length) {
            dogs[nextIndex] = dog;
            System.out.println("Dog added at " + nextIndex);
            nextIndex++;
        }
    }
}

class Dog {

}