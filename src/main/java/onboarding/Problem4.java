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

    //2번 기능
    public static String solution(String word) {
        String answer = "";

        char[] small= new char[ALPHABET];
        char[] big= new char[ALPHABET];

        for(int i=0;i<ALPHABET;i++) {
            small[i]=(char)(122-i);
            big[i]=(char)(90-i);
        }

        for(int j=0;j<word.length();j++) {
            char thisWord=word.charAt(j);
            if(checkWord(thisWord)==1) {
                answer+=big[thisWord-BIG_ALPHABET];
            }
            else if(checkWord(thisWord)==2) {
                answer+=small[thisWord-SMALL_ALPHABET];
            }
            else {
                answer+=word.charAt(j);
            }
        }

        return answer;
    }
}
