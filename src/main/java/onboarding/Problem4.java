package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = Sentence.toArray(word);
        int[] types = Sentence.getProcessTypes(chars);
        for (int i = 0; i < chars.length; i++) {
            switch (types[i]) {
                case 0:
                    chars[i] = Sentence.processUpperCase(chars[i]);
                    break;
                case 1:
                    chars[i] = Sentence.processLowerCase(chars[i]);
                    break;
                case 2:
                    continue;
                default:
                    break;
            }
        }
        return Sentence.toStringFormat(chars);
    }
}
class Sentence{
    private static final int TYPE_UPPER_CASE = 0;
    private static final int TYPE_LOWER_CASE = 1;
    private static final int TYPE_SPACE_CASE = 2;


    static int[] getProcessTypes(char[] chars) {
        int[] types = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i])) {
                types[i] = TYPE_UPPER_CASE;
            }
            else if(Character.isLowerCase(chars[i])) {
                types[i] = TYPE_LOWER_CASE;
            }
            else if(chars[i] == ' ') {
                types[i] = TYPE_SPACE_CASE;
            }
            else
                throw new IllegalArgumentException("영어 문장을 작성해주세요");
        }
        return types;
    }

    static String toStringFormat(char[] chars) {
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            bld.append(chars[i]);
        }
        return bld.toString();
    }

    static char processLowerCase(char letter){
        return (char) (letter + (109 - letter)*2 + 1);
    }
    static char processUpperCase(char letter){
        return (char) (letter + (77 - letter)*2 + 1);
    }
    static char[] toArray(String str){
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
}