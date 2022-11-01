package onboarding.problem3;

public class Counter {

    public static int count369(int number){
        int result =0;
        for(int i=1;i<=number;i++){
            result += find369(i);
        }
        return result;
    }

    public static int find369(int number){
        int count = 0;
        while(number > 0) {
            int digit = number % 10;
            if(is369(digit)){count++;}
            number = number / 10;
        }
        return count;
    }

    public static boolean is369(int number) {
        return (number == 3 || number == 6 || number == 9);
    }
}
