package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int last_index = 0;
        for(int i = 0; i < cryptogram.length(); i++){
            last_index = findLastIndex(cryptogram, i);
        }
        return answer;
    }
    public static int findLastIndex(String cryptogram, int index) {
        if (cryptogram.charAt(index) != cryptogram.charAt(index + 1)) return -1;
        int last_index = -1;
        int initial = index;
        last_index = findLastIndex(cryptogram, index++);
        // 함수의 반환값이 -1이면 현재 index가 연속된 문자의 마지막 인덱스 값
        if (last_index != -1) return last_index;
        return index;
    }
}
