package onboarding;

public class Problem3 {
    /**
     * 369 게임
     * @param number
     * @return
     */
    public static int solution(int number) {
        int answer = 0;
        if(number < 1 || number > 10000) return -1; // 숫자 범위 예외처리
        for(int i=1; i<=number; i++) {
            answer += clap(i);
        }
        return answer;
    }


    /**
     * 박수 횟수 리턴
     * @param num
     * @return count
     */
    public static int clap(int num) {
        int cnt = 0;
        String target = Integer.toString(num);
        for (char c : target.toCharArray()) {
            if (c == '3' || c == '6' || c == '9') cnt++;
        }
        return cnt;
    }
}
