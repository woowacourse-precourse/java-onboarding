package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String[][] convertMessage = new String[2][26];
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> frogAlphabet = new HashMap<>();
        convertMessage[0] = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M",
                "a","b","c","d","e","f","g","h","i","j","k","l","m"};
        convertMessage[1] = new String[]{"Z","Y","X","W","V","U","T","S","R","Q","P","O","N",
                "z","y","x","w","v","u","t","s","r","q","p","o","n"};
        for (int j = 0 ; j < convertMessage[0].length; j++){
            frogAlphabet.put(convertMessage[0][j],convertMessage[1][j]);
            frogAlphabet.put(convertMessage[1][j],convertMessage[0][j]);
        }
        for (int i = 0 ; i < word.length(); i++){
            String ch = String.valueOf(word.charAt(i));
            sb.append(ch.replace(ch,frogAlphabet.getOrDefault(ch,ch)));
        }
        return sb.toString();
    }
}
