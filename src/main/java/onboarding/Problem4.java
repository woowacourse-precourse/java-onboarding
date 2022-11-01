package onboarding;
// 1. String -> char[] & 한글자씩 확인 및 변환: solution
// 2. 대문자인지 확인: char isUpper(char)
//	1) 대문자 -> 소문자: char convertUp(char)
//	2) 소문자 -> 대문자: char convertLow(char)
public class Problem4 {
    public static String solution(String word) {
        char[] charArray = word.toCharArray();

        for(int i=0; i<charArray.length; i++ ){
            charArray[i] =isUpper(charArray[i]);
        }

        return  new String(charArray);
    }

    public static char isUpper(char ch) {
        if(ch>='A' && ch<='Z') {return convertUp(ch);}
        if(ch>='a' && ch<='z') {return convertLow(ch);}
        return ch;
    }

    public static char convertUp(char ch) {
        int gap=0;
        gap=ch-'A';
        return (char)('Z'-gap);
    }

    public static char convertLow(char ch) {
        int gap=0;
        gap=ch-'a';
        return (char)('z'-gap);
    }
}
