package onboarding;

public class Problem3 {

    public static int countThree(int number){

        int[] num = new int[5];
        int decimal = 1000;
        int sum = 0;
        num[0] = number / 10000;
        num[4] = number % 10;

        for(int i=0; i<3; i++){
            num[i] = (number % (decimal*10)) / decimal;
            decimal /= 10;
        }

        for(int i=0; i<5; i++){
            if(num[i] == 3 || num[i] == 6 || num[i] == 9){
                sum++;
            }
        }
        return sum;
    }

    public static int solution(int number) {

        int count = 0; int three = 0;
        for(int i=1; i<=number; i++){
            three = countThree(i);
            count += three;
        }
        return count;
    }
}
