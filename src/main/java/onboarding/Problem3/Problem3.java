package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // count 초기화
        int count = 0;

        // 1부터 number까지 숫자 입력
        for (int i = 1; i <= number; i ++) {
            // 숫자 i를 문자열로 변환 1 > '1'
            String num = Integer.toString(i);
            // '문자열 = String' num에서 char(i) i번째 '문자=charcter'를 꺼내 가져온다
            for (int j = 0; j < num.length(); j ++) {
                // 비교 후 3 6 9 들어가면 +1
                if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                    count ++;
                }
            }
        }
        return count;
    }
}


