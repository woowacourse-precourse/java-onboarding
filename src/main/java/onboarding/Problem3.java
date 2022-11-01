package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int cnt = 1; cnt <= number; cnt++) { // 1부터 입력 받은 숫자까지 반복
            String str = String.valueOf(cnt); // 문자열 변환
            for (int i = 0; i < str.length(); i++) {
                char chk = str.charAt(i);
                if (chk == '3' || chk == '6' || chk == '9') {//해당 일때만 answer에 1 추가
                    answer = answer + 1;
                }
            }
        }
        return answer;
    }
}
