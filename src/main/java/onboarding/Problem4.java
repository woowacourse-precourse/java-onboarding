package onboarding;

public class Problem4 {

    public static String solution(String word) {

        StringBuilder resultStringBuilder = new StringBuilder();
        if(word == null){
            return "";
        }
        char[] charArrayWord = word.toCharArray();
        if(!isValidInput(charArrayWord)){
            return "";
        }

        for (char c : charArrayWord) {
            if (isAlphabet(c)) {
                resultStringBuilder.append(decoder(c));
            } else {
                resultStringBuilder.append(c);
            }
        }
        return resultStringBuilder.toString();
    }
    private static boolean isValidInput(char[] c){
        return c.length > 0 && c.length <= 1000;
    }
    private static boolean isAlphabet(char c){
        return (c >= 'A' && c <='Z') || (c >='a' && c<='z');
    }

    private static char decoder(char input){
        char result;
        if(Character.isUpperCase(input)){
            if(input/78 < 65){
                int k = 25 - 2*(input - 65);
                result = (char)(input + k);
            }else{
                int k = 25 - 2*(90 - input);
                result = (char)(input - k);
            }
        }else{
            if(input/110 < 97){
                int k = 25 - 2*(input - 97);
                result = (char)(input + k);
            }else{
                int k = 25 - 2*(90 - input);
                result = (char)(input - k);
            }
        }
        return result;
    }
}
