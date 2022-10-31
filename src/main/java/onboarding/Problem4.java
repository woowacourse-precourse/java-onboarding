package onboarding;

public class Problem4 {
    private static Character lowerChange(char change){
        // a to z, b to x... 모두 두 문자의 아스키코드 값을 더하면 219가 된다.
        // 따라서 219에서 현재 문자의 아스키코드 값을 뺴면 변환 후 문자의 아스키코드 값이 된다.
        return (char)(219 - change);
    }

    private static Character upperChange(char change){
        // A to Z, B to X... 모두 두 문자의 아스키코드 값을 더하면 155가 된다.
        // 따라서 155에서 현재 문자의 아스키코드 값을 뺴면 변환 후 문자의 아스키코드 값이 된다.
        return (char)(155 - change);
    }

    public static String solution(String word) {
        char currentChar;

        for(int i = 0; i < word.length(); i++){
            currentChar = word.charAt(i);
            if((int)currentChar >= 97 && (int)currentChar <= 122){
                currentChar = lowerChange(currentChar);
                word = word.substring(0, i)
                        .concat(Character.toString(currentChar))
                        .concat(word.substring(i + 1));
            }
            else  if((int)currentChar >= 65 && (int)currentChar <= 90) {
                currentChar = upperChange(currentChar);
                word = word.substring(0, i)
                        .concat(Character.toString(currentChar))
                        .concat(word.substring(i + 1));
            }
        }

        return word;
    }
}
