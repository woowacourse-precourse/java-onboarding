package onboarding;

public class Problem2 {
    /**
     [기능목록]
     1. 연속하는 중복 문자 찾기 (없을 때 까지 찾기)
     2. 중복 문자를 공백으로 바꾸기
     3. 공백 문자 제거하여 결과 리턴하기
     */
    public static String solution(String cryptogram) {
        String answer = "answer";
        return remove(cryptogram);
    }
    public static String remove(String str) {
        while(true) {
            boolean check = false;
            char[] array = str.toCharArray();

            for(int i = 0; i < array.length - 1; i++) {
                // 연속하는 중복 문자 찾기 (없을 때 까지 찾기 - check 변수 이용)
                if(array[i] == array[i + 1]) {
                }
            }

            if(!check) {
                break;
            }
        }
        return str;
    }
}
