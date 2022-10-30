package onboarding;

/*
========================================Problem2 기능 목록========================================
- 1의 자리가 3, 6, 9인지 확인하는 기능
- 박수의 개수를 세는 기능
 */

public class Problem3 {
    public static boolean checkThreeSixNine(int number){
        number %= 10;
        return (number == 3 || number == 6 || number == 9);
    }

    public static int countClap(int number){
        int count = 0;

        for(int i = 1;i <= number;i++){
            int tempNum = i;
            while(tempNum > 0){
                if(checkThreeSixNine(tempNum))
                    count++;
                tempNum /= 10;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
