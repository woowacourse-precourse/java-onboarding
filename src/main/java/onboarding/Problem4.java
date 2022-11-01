package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] answer = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        if (word.length() < 1 || word.length() > 1000) {
            return "";
        }

        char[] dic = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                int dif = word.charAt(i) - 'a';
                sb.append(Character.toLowerCase(dic[25 - dif]));
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                int dif = word.charAt(i) - 'A';
                sb.append(dic[25 - dif]);
            } else {
                sb.append(word.charAt(i));
            }
        }

        return sb.toString();
    }
}
