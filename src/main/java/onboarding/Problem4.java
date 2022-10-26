package onboarding;

public class Problem4 {
    public static String solution(String word) {

        /*
        * 문장의 문자만큼 반복하여 문자를 변환한다.
        * */
        char[] wordToCharArr = word.toCharArray();
        for (int i = 0; i < wordToCharArr.length; i++) {
            if(wordToCharArr[i] ==' ') continue;
            wordToCharArr[i] = charReverse(wordToCharArr[i]);
        }

        return String.valueOf(wordToCharArr);
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
