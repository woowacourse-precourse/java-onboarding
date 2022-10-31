package onboarding;

import onboarding.p2.Cryptogram;

public class Problem2 {


    public static String solution(String cryptogram) {
        Cryptogram input = new Cryptogram(cryptogram);

        String answer = deduplication(cryptogram);
        return answer;
    }

    // 중복을 제거하는 재귀함수
    public static String deduplication(String cryptogram) {
        int length = cryptogram.length();
        StringBuilder sb = new StringBuilder();
        // 문자열을 전체적으로 탐색하여 중복이 있는지 보는 FOR문
        for (int i = 0; i < length; i++) {
            char c = cryptogram.charAt(i);
            int next = i+1;
            int count = 0;
            // 마지막 문자인지 확인
            if (i == length-1) {
                sb.append(c);
                break;
            }
            // 해당 문자가 중복이 안될 때까지 체크
            while (cryptogram.charAt(next) == c){
                count ++;
                next++;
                // 범위 벗어나는 지 체크
                if (next == length) break;
            }
            // 중복되는 문자가 아니라면 append
            if (count == 0) {
                sb.append(c);
            }
            // 중복되는 문자를 제거했을 경우 i 증가
            i += count;
        }
        String nextCryptogram = sb.toString();
        // 만약 문자가 줄어들었다면 더 줄일 필요가 있는지 확인해야함
        // 재귀 호출
        if (nextCryptogram.length() < length) {
            // 재귀 호출한 메소드에서 return하는 값을 return
            return deduplication(nextCryptogram);
        }
        // 더이상 줄일 필요가 없다면 해당 값을 return
        return nextCryptogram;
    }


}

