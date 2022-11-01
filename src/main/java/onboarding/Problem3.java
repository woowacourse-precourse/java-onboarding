package onboarding;



public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        // 1~number까지 순회
        for (int num = 1; num <= number; num++) {
            String str = Integer.toString(num);
            // 숫자를 문자열로 만들어서 자릿수 하나씩 탐색
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // 3, 6, 9에 해당되면 +1 count
                if (ch == '3' || ch == '6' || ch == '9') {
                    answer += 1;
                }
            }
        }


        return answer;
    }





}
