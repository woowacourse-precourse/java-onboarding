package onboarding;


public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        char[] words = word.toCharArray();

        validateCase(word);

        for(int i=0 ; i < words.length ; i++){
            if( (byte) words[i] == 32){  //공백 유지
                continue;
            } else if( (byte) words[i] > 90 ){  //대문자
                words[i] = (char)(219 - (byte) words[i]);
            } else {  //소문자
                words[i] = (char)(155 - (byte) words[i]);
            }
        }

        answer = String.valueOf(words);

        return answer;
    }

    public static void validateCase(String word){
        if( word.length() < 1 || word.length() > 1000) throw new RuntimeException("문자열의 길이가 적합하지 않습니다.");
    }
}
