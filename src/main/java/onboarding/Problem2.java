package onboarding;

public class Problem2 {
    public static String removeDuplicate(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        cryptogram = "browoanoommnaonnni";
        char ch = cryptogram.charAt(0);
        int cnt = 1;
        for (int i = 1; i < cryptogram.length(); i++) {
            if(ch == cryptogram.charAt(i)) {
                cnt++;
            }else {
                if(cnt > 1) {
                    cryptogram = cryptogram.replace(String.valueOf(ch).repeat(cnt), "");
                }
                ch = cryptogram.charAt(i);
                cnt = 1;
            }
            System.out.println(cryptogram +", " +cryptogram.length());
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static boolean isNotDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true) {
            if(cryptogram.equals("")) {
                answer = "";
                break;
            }

            if(isNotDuplicate(cryptogram)) {
                answer = cryptogram;
                break;
            }

            cryptogram = removeDuplicate(cryptogram);
        }

        return answer;
    }
}
