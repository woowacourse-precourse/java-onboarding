package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countThreeSixNine(number);
        return answer;
    }

    public static int countThreeSixNine(int number){
        int count = 0;
        int tmpNumber;
        int unitNumber;

        for(int i=1; i<= number; i++){
            tmpNumber = i;
            while(tmpNumber > 0){
                unitNumber = tmpNumber % 10;
                if((unitNumber == 3) || (unitNumber == 6) || (unitNumber == 9))
                    count++;
                tmpNumber /= 10;
            }
        }

        return count;
    }
}
