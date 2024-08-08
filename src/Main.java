

public class Main {
    public static void main(String[] args) {

        int teeth = 20;
        boolean canine = true, wolf = true;

        canine = (teeth!=10) ^ (wolf=false);
        System.out.println(canine);

    }
}