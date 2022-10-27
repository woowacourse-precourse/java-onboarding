package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;

        for (int i=1; i<=number; i++) {
            String str = String.valueOf(i); // int -> string 변환

            // 예를 들어, 36 이라는 숫자에는 박수 두 번
            for (int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
