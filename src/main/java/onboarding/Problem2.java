package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        //같은게 더이상 안나온다면 끝내기
        boolean check = true;
        while(check) {
            check = false;
            // 0번 부터 길이-2번 까지
            for (int i = 0; i < sb.length() - 1; i++) {
                // 만약 같은게 나온다면 그 다음 문자들까지 같은지 확인 후 삭제
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    int j = i + 1;
                    while (sb.charAt(i) == sb.charAt(j)) {
                        j++;
                        if (j >= sb.length()) break;
                    }
                    sb.delete(i, j);
                    // 삭제를 하고 i번째를 다시 확인
                    i = i - 1;
                    check = true;
                }
            }
        }
        return sb.toString();
    }
}
