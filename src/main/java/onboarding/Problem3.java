package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
    private static boolean exception(int number) {
        if(number < 1 || number > 1000){
            return false;
        }

        return true;
    }
    static int clap_count(int num){
        // num의 각 자리를 알아보기 위해 String tmp 선언
        String tmp = Integer.toString(num);
        // 총 카운트 횟수
        int cnt = 0;

        // 각 자리의 숫자들을 보며 3, 6, 9이면 cnt를 1씩 증가시킨다.
        for (int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '3'
                || tmp.charAt(i) == '6'
                || tmp.charAt(i) == '9'){
                cnt++;
            }
        }

        return cnt;
    }
}
