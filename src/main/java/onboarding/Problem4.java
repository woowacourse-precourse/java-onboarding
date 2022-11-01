package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String[] splitWord = word.split("");
        int size = splitWord.length;
        String[] reverseWord = new String[size];
        for(int i = 0; i < size ; i++){
            reverseWord[i] = reverseAlphabet(splitWord[i]);
        }
        return String.join("",reverseWord);
    }
    private static String reverseAlphabet(String str){
        if(!Character.isAlphabetic(str.charAt(0))){
            return str;
        }
        /* 아스키코드 형태로 변환 */
        int k = str.charAt(0);
        /* 대문자 소문자 판별 */
        if (k>=97){
            k = k < 110 ? (109 + Math.abs(k-109) + 1) :
                    (110 - (Math.abs(k-110) + 1));
        }else{
            k = k < 78 ? (77 + Math.abs(k-77) + 1) :
                    (78 - (Math.abs(k-78) + 1));
        }
        return Character.toString((char)k);
    }
}
