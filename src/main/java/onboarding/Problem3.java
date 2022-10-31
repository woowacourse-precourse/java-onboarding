package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;


        int count1To10 = 3;
        int count1To100 = count1To10*10 + 10*3; //60
        int count1To1000 = count1To100*10 + 100*3; //900
        ArrayList<Integer> ArrayOfCount = new ArrayList<>();
        ArrayOfCount.add(0);
        ArrayOfCount.add(count1To10);
        ArrayOfCount.add(count1To100);
        ArrayOfCount.add(count1To1000);

        ArrayList<Integer> numberEachDigitArray = new ArrayList<>();

        while (number > 0) {

            numberEachDigitArray.add(number%10);
            number /= 10;

        }

        int sizeOfNumber = numberEachDigitArray.size();

        while (sizeOfNumber > 0) {

            answer += ArrayOfCount.get(sizeOfNumber-1) * numberEachDigitArray.get(sizeOfNumber-1);

            int quotientOfEachDigit = numberEachDigitArray.get(sizeOfNumber-1) / 3;
            int pow = 1;
            int powValue = 1;
            while (pow < sizeOfNumber) { //제곱 수 구해주기
                powValue *= 10;
                pow += 1;
            }

            answer += quotientOfEachDigit * powValue;

            sizeOfNumber -= 1;
        }




        return answer;
    }
}
