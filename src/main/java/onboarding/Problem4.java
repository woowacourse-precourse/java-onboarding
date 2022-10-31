package onboarding;

public class Problem4 {
    // 조건대로 입력받은 문자열을 변환하여 결과 문자열을 리턴
    public static String getResult(String word) {
        StringBuilder sb = new StringBuilder();

        // 아스키 코드 번호를 이용
        int low = 'a' + 'z';
        int upper = 'A' + 'Z';

        for(int i=0; i<word.length(); i++) {
            char cur = word.charAt(i);

            // 대, 소문자를 구분하여 값 변환
            if( 'a' <= cur && cur <= 'z') {
                sb.append((char)(low - cur));
                continue;
            }
            if( 'A' <= cur && cur <= 'Z') {
                sb.append((char)(upper - cur));
                continue;
            }
            sb.append(cur);
        }

        return sb.toString();
    }
    public static String solution(String word) {
        String answer = getResult(word);
        return answer;
    }
}
