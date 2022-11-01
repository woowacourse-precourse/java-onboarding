package onboarding;

public class Problem4 {
    static char[] upper = new char[27];
    static char[] lower = new char[27];

    //대문자와 소문자의 각 문자에 대한 변환될 문자를 배열에 미리 저장해준다.
    public static void saveReverse(){
        for(int i=0; i<26; i++) {
            upper[i] = (char)(90-i);
            lower[i] = (char)(122-i);
        }
    }

    public static String solution(String word) {
        saveReverse();
        String result = "";
        for(int i=0; i<word.length(); i++) {
            result = concatString(result, i, word.charAt(i));
        }
        return result;
    }
}

