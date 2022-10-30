package onboarding;

/**
 * 알파벳인지 타 문자인지 확인하는 기능을 위한 클래스
 */
class JudgeAlphabet{
    public boolean isAlpha(char ch){
        return (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'));
    }
}

/**
 * 아스키코드와 관련된 기능을 하는 클래스
 * 1. 아스키 코드 반환
 * 2. 문자가 'A or a'와 'Z or z' 중 어디에 더욱 가까운지
 * 3. 2번 정보를 이용하여 반대 위치에 해당하는 문자 반환
 */
class CalculateASCII{
    public int getASCII(char ch){
        return (int)ch;
    }

    public boolean isCloselyUpperA(int value){
        int closelyA = Math.abs((int)'A' - value);
        int closelyB = Math.abs((int)'Z' - value);

        return closelyA < closelyB;
    }

    public boolean isCloselyLowerA(int value){
        int closelyA = Math.abs((int)'a' - value);
        int closelyB = Math.abs((int)'z' - value);

        return closelyA < closelyB;
    }

    public char getReverseWordUpperCase(boolean flag, char ch){
        // 'A'와 더욱 가까이 있는 경우
        if(flag){
            int abs = Math.abs((int) 'A' - getASCII(ch));
            return ((char)((int)'Z' - abs));
        } else{
            int abs = Math.abs((int)'Z' - getASCII(ch));
            return ((char)((int)'A' + abs));
        }
    }

    public char getReverseWordLowerCase(boolean flag, char ch){
        if(flag){
            int abs = Math.abs((int) 'a' - getASCII(ch));
            return ((char)((int)'z' - abs));
        } else{
            int abs = Math.abs((int)'a' - getASCII(ch));
            return ((char)((int)'z' + abs));
        }
    }
}

class ReverseWord{
    JudgeAlphabet judgeAlphabet = new JudgeAlphabet();
    CalculateASCII calculateASCII = new CalculateASCII();

    public String getReverse(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(!judgeAlphabet.isAlpha(word.charAt(i))){
                stringBuilder.append(word.charAt(i));
            } else{
                int ascii = calculateASCII.getASCII(word.charAt(i));
                if(Character.isUpperCase(word.charAt(i))){
                    boolean isCloselyUpperA = calculateASCII.isCloselyUpperA(ascii);
                    if(isCloselyUpperA){
                        stringBuilder.append(calculateASCII.getReverseWordUpperCase(isCloselyUpperA, word.charAt(i)));
                    } else{
                        stringBuilder.append(calculateASCII.getReverseWordUpperCase(!isCloselyUpperA, word.charAt(i)));
                    }
                } else{
                    boolean isCloselyLowerA = calculateASCII.isCloselyLowerA(ascii);
                    if(isCloselyLowerA){
                        stringBuilder.append(calculateASCII.getReverseWordLowerCase(isCloselyLowerA, word.charAt(i)));
                    } else{
                        stringBuilder.append(calculateASCII.getReverseWordLowerCase(!isCloselyLowerA, word.charAt(i)));
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}

public class Problem4 {

    private final static ReverseWord reverseWord = new ReverseWord();
    public static String solution(String word) {
        return reverseWord.getReverse(word);
    }
}
