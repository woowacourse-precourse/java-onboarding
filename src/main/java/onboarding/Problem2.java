package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = CheckOverlap(cryptogram);
        return answer;
    }

    public static String CheckOverlap(String cryptogram) {
        boolean checker = true; // 중복 검사기
        char[] cryptogramArray;
        int index = 0;
        do {
            cryptogramArray = cryptogram.toCharArray();
            cryptogram = new String();
             
        } while (checker);

        return cryptogram;
    }



}
