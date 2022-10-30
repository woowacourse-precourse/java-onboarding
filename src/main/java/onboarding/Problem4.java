package onboarding;

/**
 * 기능 구현 사항
 * 1. 문자 반대로 변환
 *  1-1 알파벳 외의 문자는 변환 x
 *  1-2 대문자는 대문자, 소문자는 소문자로 변환 o
 * 2. 문자 합쳐서 문자열로 합치기
 */
public class Problem4 {

    private static boolean isUpperCase(char alp){
        int alpCode = (int) alp;
        return (65 <= alpCode && alpCode <= 90);
    }
    private static boolean isLowerCase(char alp){
        int alpCode = (int) alp;
        return (97 <= alpCode && alpCode <= 122);
    }
    private static char reverseAlphaBet(char alp){

        if (isUpperCase(alp)){
            return (char)('Z' - alp + 'A');
        } else if (isLowerCase(alp)) {
            return (char)('z' - alp + 'a');
        }else{
            return alp;
        }
    }
    public static String solution(String word) {

        char[] reverseCharArray = new char[word.length()];
        for (int i = 0; i< word.length(); i++){
            reverseCharArray[i] = reverseAlphaBet(word.charAt(i));
        }

        return new String(reverseCharArray);
    }
}
