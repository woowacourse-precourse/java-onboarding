package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return to_chung_flog_word(word);
    }

    public static String to_chung_flog_word(String word){
        String chung_word = "";
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == ' ') {
                chung_word += ' ';
                continue;
            }
            char chung_lang = chung_frog_lang(c);
            if (chung_lang != 0)
                chung_word += chung_lang;
        }
        System.out.println(chung_word);
        return chung_word;
    }

    public static char chung_frog_lang(char c){
        char chung_lang = 0; // 0이 리턴되면 예외값
        if(c >= 'a' && c <= 'z'){
            chung_lang = (char)('z' - c + 'a');
        }
        else if(c >= 'A' && c <= 'Z'){
            chung_lang = (char)('Z' - c + 'A');
        }

        return chung_lang;
    }
}
