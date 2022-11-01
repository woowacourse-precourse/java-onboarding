/*
 * Problem3
 *
 * v1.1
 *
 * 2022.11.02
 *
 * 저작권 주의
 */


package onboarding;



public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number+1; i++){
            answer+=checkNumber(i);
        }
        return answer;
    }

    static int checkNumber(int number){
        int [] numArray = NumAndArray.makeNumToArray(number);
        int count = 0;
        for (int num : numArray) {
            count= checkAddCount(count, num);
        }
        return count;
    }
    static int checkAddCount(int count, int number){
        if (number == 3 || number == 6 || number == 9) {
            count=count+1;
        }
        return count;
    }

}
