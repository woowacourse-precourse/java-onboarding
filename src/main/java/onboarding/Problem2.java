package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (!cryptogram.equals(returnNewString(cryptogram))) {
            cryptogram = returnNewString(cryptogram);
            if(cryptogram.equals("")) break;
        }

        return cryptogram;
    }
    public static int findLastIndex(String cryptogram, int index) {
        if(index == cryptogram.length()-1) return -1;
        if (cryptogram.charAt(index) != cryptogram.charAt(index + 1)) return -1;
        int last_index = -1;
        int initial = index;
        last_index = findLastIndex(cryptogram,++index);
        // 함수의 반환값이 -1이면 현재 index가 연속된 문자의 마지막 인덱스 값
        if (last_index != -1) return last_index;
        return index;
    }

    public static String returnNewString(String cryptogram) {
        int last_index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram);
        int len = cryptogram.length();

        for(int i = 0; i < len; i++) {
            if (i == len -1) break;
            last_index = findLastIndex(cryptogram, i);
            if (last_index == -1) continue;
            sb.delete(i, last_index + 1);
            cryptogram = sb.toString();
            i = last_index;
            return cryptogram;
        }
        return cryptogram;
    }
}
