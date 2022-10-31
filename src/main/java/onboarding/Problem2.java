package onboarding;

public class Problem2 {
    public static String findDuplication(String cryptogram) {
        char prevChar = cryptogram.charAt(0);
        String indexes = "";

        while(true) {
            for(int i = 1; i < cryptogram.length(); i++) {
                if(prevChar == cryptogram.charAt(i)) {
                    indexes += Integer.toString(i - 1) + " ";
                    indexes += Integer.toString(i) + " ";
                }
                prevChar = cryptogram.charAt(i);
            }
            if(indexes.length() == 0) {
                break;
            }
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        findDuplication(cryptogram);
        String answer = "answer";
        return answer;
    }

    public static void main(String[] args) {
        solution("browoanoommnaon");
    }
}
