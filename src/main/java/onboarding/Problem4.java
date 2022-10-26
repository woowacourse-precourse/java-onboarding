package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /*
    * 대소문자를 구분하여, 반대 문자로 바꾼다.
    * */
    private static char charReverse(char chr){
        if(chr>='A' && chr<='Z'){
            return (char)('A'+('Z'-chr));
        }else{
            return (char)('a'+('z'-chr));
        }
    }
}
