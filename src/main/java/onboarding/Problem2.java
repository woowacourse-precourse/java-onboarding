package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            String removeString = removeDuplicate(cryptogram);
            if(cryptogram.equals(removeString)) {
                break;
            }
            cryptogram = removeString;
        }
        return cryptogram;
    }

    private static String removeDuplicate(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char prev = 0;
        int i = 0;

        for(char c : chars) {
            if(prev!=c) {
                chars[i++] = c;
                prev = c;
                sb.append(c);
            } else {
                sb.delete(sb.length()-1, sb.length());
            }
        }
        return sb.toString();
    }
}
