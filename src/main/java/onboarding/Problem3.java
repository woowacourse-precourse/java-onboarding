package onboarding;
//블로그 참고후 진행
public class Problem3 {
    public int solution(int number) {
        return count(number);
    }
    private int count(int number) {
        int result = 0;
        for (int cnt = 1; cnt <= number; cnt++) {
            String str = String.valueOf(cnt); // 문자열 변환

            for (int i = 0; i < str.length(); i++) {
                char chk = str.charAt(i);
                if (chk == '3' || chk == '6' || chk == '9') result += 1;
            }
        }
        return result;
    }
}
