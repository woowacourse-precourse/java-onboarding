package onboarding;

//문제 4번 기능 요구사항
//1. 대문자인지 소문자인지 문자 아닌지 판별
//2. 문자이면 변환해서 반환해준다.

public class Problem4 {

    public static final int ALPHABET=26;
    public static final int BIG_ALPHABET=65;
    public static final int SMALL_ALPHABET=97;

    //1번 기능
    public static int checkWord(char ch) {

        if(ch>=65&&ch<=90)
            return 1;	//대문자
        else if(ch>=97&&ch<=122)
            return 2;	//소문자
        else
            return 0;	//문자 아님
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
