package onboarding;

public class Problem4 {
    public static boolean isAlphabet(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static char chungGaeGuRi(char alphabet){
        int a = (int) alphabet;

        if ( alphabet >= 65 && alphabet <= 90 ){
            a = 90 - (a - 65);
        }else {
            a = 122 - (a- 97);
        }

        return (char) a;
    }
    public static String solution(String word) {
        String answer = "";

        for(char c : word.toCharArray()){
            if( isAlphabet(c)) {
                answer += chungGaeGuRi(c);
            }
            else{
                answer += c;
            }
        }

        return answer;
    }
}
