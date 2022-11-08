package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char [] arrWord = word.toCharArray();

        for (int i=0;i< arrWord.length;i++){
            arrWord[i] = converse(arrWord[i]);
        }

        return new String(arrWord);
    }

    // 문자를 받아, 아스키코드로 바꾸고, 알파벳일 경우 뒤집어서 반환
    private static char converse(char c){
        int ascii = (int)c;

        if (ascii>=65 && ascii<=122){
            if (ascii <= 90){
                ascii = 90+65-ascii;
            }
            else{
                ascii = 122+97-ascii;
            }
        }

        return (char)ascii;
    }
}
