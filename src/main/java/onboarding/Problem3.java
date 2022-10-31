package onboarding;

import java.util.List;

public class Problem3 {
    public static int maxNumber=10000;
    public static Integer[] handclapCountList=new Integer[maxNumber+1];

    public static int countHandclapByNumber(int number){
        int handclapCount=0;
        while(number>0){
            int eachDigitOfNumber=number%10;
            if(eachDigitOfNumber!=0 && eachDigitOfNumber%3==0){
                handclapCount++;
            }
            number/=10;
        }
        return handclapCount;
    }
    public static void recordHandclapByNumber() {
        for (int num = 1; num <= maxNumber; num++) {
            int handclapResultByNumber = countHandclapByNumber(num);
            handclapCountList[num] = handclapResultByNumber;
        }
    }

    public static int getSumOfEntireHandclap(int number){
        int sumOfEntireHandclap=0;
        for(int numIndex=0;numIndex<number;numIndex++){
            sumOfEntireHandclap+=handclapCountList[numIndex];
        }
        return sumOfEntireHandclap;
    }

    public static int solution(int number) {
        int answer = 0;
        answer=getSumOfEntireHandclap(number);
        return answer;
    }
}
