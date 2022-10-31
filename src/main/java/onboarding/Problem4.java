package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 대문자는 대문자로 소문자는 소문자로
        // 각 문자 인덱스찾아서 반대로 변환해 변환하기
//        char[] alpha = new char[26];
//
//        for(int i = 0, cnt = 65; i < alpha.length; i++, cnt++){
//            alpha[i] = (char) cnt;
//        }

        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c >= 65 && c <= 90){ // 대문자
                int index = 90 - c;
                char tmp = alpha.charAt(index);
                tmp = Character.toUpperCase(tmp);
                answer += tmp;
            }
            else if (c >= 97 && c <= 122){ // 소문자
                int index = 122 - c;
                char tmp = alpha.charAt(index);
                answer += tmp;
            }
            else{ // 그 외
                answer += c;
            }
        }


        return answer;
    }
}
