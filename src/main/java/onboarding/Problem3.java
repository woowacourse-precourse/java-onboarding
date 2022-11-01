package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int divideNum;
        for (int i = number; i >= 1; i--) {
            int temp;
            int numberTocal = i;
            divideNum = 10000;
            while(divideNum != 0){
                if(divideNum != 0) {
                    temp = numberTocal / divideNum;
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer += 1;
                    }
                    numberTocal = numberTocal - temp * divideNum;
                    divideNum = divideNum / 10;
                }
            }
        }
        return answer;
    }
}
