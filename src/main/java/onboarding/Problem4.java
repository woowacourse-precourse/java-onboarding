package onboarding;

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
