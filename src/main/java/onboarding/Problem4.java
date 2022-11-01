package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        StringBuilder sb = new StringBuilder(); //반대로 변환한 문자 저장
        char[] lower, upper; // 소문자, 대문자 배열
        int index; // 배열 접근 인덱스

        // 소문자 배열 초기화
        lower = new char[26];
        for(int i=0; i<lower.length; i++) {
            lower[i] = (char)(97+i);
        }
        // 대문자 배열 초기화
        upper = new char[26];
        for(int i=0; i<upper.length; i++) {
            upper[i] = (char)(65+i);
        }

        char c; // 문자열에서 문자 저장
        for(int i=0; i<word.length(); i++) {
            c = word.charAt(i);

            //문자열의 단어가 공백인 경우
            if(c == ' ') {
                sb.append(' ');
            }
            //대문자인 경우
            else if(c >= 'A' && c <= 'Z') {
                index = (int)('Z' - c);
                sb.append(upper[index]);
            }
            //소문자인 경우
            else {
                index = (int)('z'- c);
                sb.append(lower[index]);
            }
        }
        answer = sb.toString();

        return answer;
    }
}
