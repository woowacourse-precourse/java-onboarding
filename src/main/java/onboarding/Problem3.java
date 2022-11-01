/*
 * 클래스명: Problem3
 *
 * 시작 날짜: 2022-10-29
 */

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        ClapCount clapCount = new ClapCount();
        int answer = clapCount.clapCount(number);
        return answer;
    }
}

class ClapCount {
    public int clapCount(int lastNumber) {
        int crap = 0;
        for (int i=1; i<=lastNumber; i++){
            int nowNumber = i;
            while (nowNumber > 0){
                if (nowNumber % 10 == 3){
                    crap ++;
                    nowNumber /= 10;
                    continue;
                }
                if (nowNumber % 10 == 6){
                    crap ++;
                    nowNumber /= 10;
                    continue;
                }
                if (nowNumber % 10 == 9){
                    crap ++;
                    nowNumber /= 10;
                    continue;
                }
                nowNumber /= 10;
            }
        }
        return crap;
    }
}