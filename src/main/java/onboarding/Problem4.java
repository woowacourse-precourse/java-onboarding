package onboarding;

public class Problem4 {
    public static String solution(String word) {

        return switchStr(word);
    }


    public static String switchStr(String word){
        char update;
        int len = word.length();

        for(int i=0; i<len;i++){

            update = word.charAt(i);

            if(update >= 'A' && update <= 'Z'){
                update = switchUpperCase(update);
            }
            if(update >= 'a' && update <='z'){
                update = switchLowerCase(update);
            }

            word = updateStr(update, word, i);
        }

        return word;
    }

    public static String updateStr(char update, String word, int idx){
        return word.substring(0, idx)+update +word.substring(idx+1);
    }

    public static char switchUpperCase(char now){
        return (char)('Z' - (now - 'A'));
    }

    public static char switchLowerCase(char now){
        return (char)('z' - (now - 'a'));
    }
}
