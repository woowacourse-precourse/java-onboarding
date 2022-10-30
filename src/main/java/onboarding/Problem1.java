package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // must decide which calculation produces greater value (multiplication vs. addition)
        // must extract each digit

        int pobiNumber = finalNumber(pobi);
        int crongNumber = finalNumber(crong);

        int answer;

        if(pobiNumber==crongNumber) answer = 0;
        else if(pobiNumber==-1 || crongNumber==-1) answer = -1;
        else{
            answer = (pobiNumber > crongNumber) ? 1 : 2;
        }
        return answer;
    }

    // must determine how many digits the number consists of
    public static int digitNumber(int givenNum){
        if(givenNum <= 1 || givenNum >=400) return -1;

        int count = 0;
        while(givenNum>0){
            givenNum /= 10;
            count++;
        }
        return count;
    }

    // then store each digit into different variables &  determine between multiplication vs. addition
    // return whichever one is greater
    public static int greaterNumber(int num){
        int digitNum = digitNumber(num);

        int onesDigit = -1;
        int tensDigit = -1;
        int hundredsDigit = -1;
        int addition = -1;
        int multiplication = -1;

        switch (digitNum){

            case 1:
                    return 1;
            case 2:
                    onesDigit = num % 10;
                    tensDigit = num / 10 % 10;

                    addition = onesDigit + tensDigit;
                    multiplication = onesDigit * tensDigit;
                    return Math.max(addition, multiplication);
            case 3:
                    onesDigit = num % 10;
                    tensDigit = num / 10 % 10;
                    hundredsDigit = num/100;

                    addition = onesDigit + tensDigit + hundredsDigit;
                    multiplication = onesDigit * tensDigit * hundredsDigit;
                return Math.max(addition, multiplication);
            default:
                return -1;
        }
    }

    public static int finalNumber(List<Integer> list){
        // if the list is empty, OR even page - odd page != 1, OR first number is not odd, OR second number is not even
        // OR page number is either 1 or 400
        if(list==null || list.get(1)-list.get(0)!=1 || list.get(0)%2!=1 || list.get(1)%2!=0 || greaterNumber(list.get(0))==-1 || greaterNumber(list.get(1))==-1){
            return -1;
        }
        return Math.max( greaterNumber(list.get(0)), greaterNumber(list.get(1)) );
    }

}