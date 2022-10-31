package onboarding;

public class Problem2 {
    static boolean global_isRepeat;

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        global_isRepeat = true;

        while(global_isRepeat) {
            if(answer.equals("")) break;
            answer = decode_cryptogram(answer);
        }

        return answer;
    }

    public static String decode_cryptogram(String cryptogram) {
        boolean isChange = false;

        for(int iter = 0; iter < cryptogram.length(); iter++) {
            String s = check_duplicate_char(iter, cryptogram);
            if(!cryptogram.equals(s)) {
                cryptogram = s;
                iter -= 1;
                isChange = true;
            }
        }

        global_isRepeat = isChange;
        return cryptogram;
    }

    public static String check_duplicate_char(int iter, String word) {
        String new_word = word;
        char c = word.charAt(iter);
        int endIndex = iter;

        for(int i = iter + 1; i < word.length(); i++) {
            if (c != word.charAt(i)) break;
            endIndex += 1;
        }

        if(endIndex != iter) {
            new_word = new_word.replaceFirst(new_word.substring(iter, endIndex + 1), "");
        }

        return new_word;
    }
}