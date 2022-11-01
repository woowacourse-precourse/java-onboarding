package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1. 주어진 숫자(number)를 문자열로 변경함
        String numStr = numberToString(number);

        // 2. 1 ~ number 사이의 수 중에서 박수를 치는 횟수를 카운트함
        for(int i=1 ; i<=number ; i++)
            answer += getCount(numberToString(i));

        return answer;
    }

    // 입력받은 수를 문자열로 변환하여 반환함
    private static String numberToString(int number) {
        return Integer.toString(number);
    }

    // 주어진 숫자 문자열에 들어있는 '3', '6', '9'의 수를 카운트
    private static int getCount(String numStr) {
        int count = 0;
        for(int i=0 ; i<numStr.length() ; i++)
            if(numStr.charAt(i) == '3' || numStr.charAt(i) == '6' || numStr.charAt(i) == '9')
                count++;
        return count;
    }
}
