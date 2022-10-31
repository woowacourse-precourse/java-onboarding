package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        answer = decodeString(cryptogram);

        return answer;
    }

    public static String decodeString(String cryptogram) {
        if(cryptogram.length() <= 1) {
            return cryptogram;
        }

        StringBuilder newStringBuilder = new StringBuilder();

        for(int i = 0; i < cryptogram.length(); i++) {
            pushOrSkip(i, cryptogram, newStringBuilder);
        }

        if(cryptogram.equals(newStringBuilder.toString())) {
            return cryptogram;
        } else {
            return decodeString(newStringBuilder.toString());
        }
    }

    public static void pushOrSkip(int idx, String cryptogram, StringBuilder newStringBuilder) {
        if(idx == 0) {
            if(cryptogram.charAt(idx) != cryptogram.charAt(idx + 1)) {
                newStringBuilder.append(cryptogram.charAt(idx));
            }
        } else if(idx == cryptogram.length() - 1) {
            if(cryptogram.charAt(idx) != cryptogram.charAt(idx - 1)) {
                newStringBuilder.append(cryptogram.charAt(idx));
            }
        } else {
            if((cryptogram.charAt(idx) != cryptogram.charAt(idx - 1)) && (cryptogram.charAt(idx) != cryptogram.charAt(idx + 1))) {
                newStringBuilder.append(cryptogram.charAt(idx));
            }
        }
        return;
    }

}
