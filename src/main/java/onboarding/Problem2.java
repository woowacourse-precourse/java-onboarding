package onboarding;

public class Problem2 {
    public static String delSame(String cryptogram, int i) {
        char tar = cryptogram.charAt(i);
        int count = cryptogram.length() - cryptogram.replaceAll(String.valueOf(tar),"").length();
        int temp = i;
        int start = i;
        int end = i;

        if (count == cryptogram.length()){
            return "";
        }

        if (i > 0 && tar == cryptogram.charAt(i - 1)){
            while (start > 0 && tar == cryptogram.charAt(i)){
                start -= 1;
                i -= 1;
            }
        }

        i = end;

        if (i < cryptogram.length() - 1 && tar == cryptogram.charAt(i + 1)){
            while (end < cryptogram.length() - 1 && tar == cryptogram.charAt(i)){
                end += 1;
                i += 1;
            }
        }

        if (start != end){
            if (end == cryptogram.length() -1 && tar == cryptogram.charAt(end)) {
                cryptogram = cryptogram.substring(0, start);
            } else if (temp > start) {
                cryptogram = cryptogram.substring(0, start + 1) + cryptogram.substring(end + 1);
            } else {
                cryptogram = cryptogram.substring(0, start) + cryptogram.substring(end);
            }
        }

        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        int i = 0;
        while (i < cryptogram.length()) {
            String temp = cryptogram;
            cryptogram = delSame(cryptogram, i);

            if(temp.length() == cryptogram.length()) {
                i += 1;
            } else if (i != 0 && temp.charAt(i) != cryptogram.charAt(i)) {
                i -= 1;
            }
        }
        answer = cryptogram;
        return answer;
    }
}
