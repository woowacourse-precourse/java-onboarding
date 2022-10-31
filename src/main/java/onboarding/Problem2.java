package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while(true) {

            int start = findDuplicateStartChar(cryptogram);

            if(start != -1) { //문자열 중복 끝나는 지점
                int end = findDuplicateEndChar(cryptogram, start);

                String revisedCryptogram = removeDuplicatedWord(cryptogram, start, end);
                if(revisedCryptogram.equals(cryptogram)) {
                    break;
                }
                cryptogram = revisedCryptogram;
            } else break;
        }
        return cryptogram;
    }

    public static int findDuplicateStartChar(String cryptogram) {
        int start = -1; //문자열 중복 시작 지점
        for(int i = 0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                start = i; break;
            }
        }
        return start;
    }

    public static int findDuplicateEndChar(String cryptogram, int start) {
        int end = start;
        for(int i = start; i<cryptogram.length(); i++) {
            if(cryptogram.length() == 2) return start + 1;
            if(cryptogram.charAt(start) != cryptogram.charAt(i+1)) {
                end = i; break;
            }
        }
        return end;
    }

    public static String removeDuplicatedWord(String cryptogram, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram);
        sb.replace(start, end+1, "");
        return sb.toString();
    }
}