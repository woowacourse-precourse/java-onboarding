package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (checkForDuplication(answer)) {
            answer = removeDuplication(answer);
        }

        return answer;
    }

    // 중복이 있는지만 검사
    static boolean checkForDuplication (String cryptogram) {
        for(int i = 1; i < cryptogram.length(); i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                return true;
            }
        }
        return false;
    }

    static String removeDuplication (String cryptogram) {
        String answer = "";
        boolean dup = false;

        // 마지막 문자는 i+1이 배열 밖이므로 length-1 미만 까지 반복
        for(int i = 0; i < cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) {
                if (dup) {
                    dup = false;
                    continue;
                }
                answer += cryptogram.charAt(i);
            }
            else {
                dup = true;
            }
        }

        // 마지막 문자
        if(!dup) {
            answer += cryptogram.charAt(cryptogram.length()-1);
        }

        return answer;
    }

}
