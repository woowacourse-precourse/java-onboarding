package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        int temp;

        for(int i=1; i<= number; i++){
            temp = i;
            count += countThreeSixNine(temp);
        }

        return count;
    }

    public static int countThreeSixNine(int num){
        int unitNumber;
        int count = 0;
        while(num > 0){
            unitNumber = num % 10;
            if((unitNumber == 3) || (unitNumber == 6) || (unitNumber == 9))
                count++;
            num /= 10;
        }
        return count;
    }
}
