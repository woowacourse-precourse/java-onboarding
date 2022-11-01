/*
 * Problem3
 *
 * v1.1
 *
 * 2022.11.01
 *
 * 저작권 주의
 */


package onboarding;



public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number+1; i++){
            answer+=check369Number(i);
        }
        return answer;
    }

    static int check369Number(int number){
        int [] ArrayNum = NumAndArray.makeNumToArray(number);
        int count = 0;
        for (int num : ArrayNum) {
            if (num == 3 || num == 6 || num == 9) {
                count++;
            }
        }
        return count;
    }

}
