package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordchar = word.toCharArray();
        int reverse = 0;
        int gap =0;
        int ascii = 0;

        for (int i = 0; i < wordchar.length; i++) {

            if (Character.isUpperCase(wordchar[i])) {
                ascii = 65;
                //소문자 시작
            } else if (Character.isLowerCase(wordchar[i])) {
                ascii = 97;
                //대문자 시작
            } else if(wordchar[i] == ' '){
                answer = answer + ' ';
                continue;
                //공백 처리
            } else{
                answer = answer + wordchar[i];
                continue;
                //이외 문자
            }
            gap = Math.abs(ascii - wordchar[i]);
            // 65 ~ 90 대문자  -사이 25개
            // 97 ~ 122 소문자  -사이 25개
            reverse = (ascii + 25) - gap;
            //차이만큼 뺀 값 = 찾는 값
            answer = answer + String.valueOf((char) reverse);

        }
        return answer;
    }
}
