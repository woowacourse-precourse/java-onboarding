package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int nowNum=1; nowNum<=number; nowNum++){
            answer += countClap(nowNum);
        }
        return answer;
    }
    public static int countClap(int number) {
        int cnt = 0;
        String strNum = Integer.toString(number);
        for (int i=0; i<strNum.length(); i++) {
            int ithNum = Integer.parseInt(strNum.substring(i,i+1));
            if (ithNum != 0 && ithNum % 3 == 0 ) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
