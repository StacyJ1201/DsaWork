package Array;

//WAP(WRITE A PROGRAM) to print all the prime numbers  combination of the given number
//input n=80
//output =
//        80=7+73
//        80=13+67
//        80=19+61
//        80=37+43


public class PrimeSum {
    public static void main(String[] args) {
        int input = 85;

       isItPrime(input);

    }

    private static void isItPrime(int input){

        for (int i = 0; i < input; i++) {
            if (primeNum(input)){
                System.out.println("No prime numbers");
                return;
            } else {

            }
        }

    }

    private static boolean primeNum(int num){

        for (int i = 2; i < Math.sqrt(num); i+=2) {
            if (num % i == 0){
                return true;
            }
        }
        return false;
    }
}
