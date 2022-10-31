package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Integer> duplicateIndex = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);

        do {
            // 여러 번 진행하기 위해 초기화
            duplicateIndex.clear();

            for(int i = 0; i < sb.length() - 1; i++) {
                String nowString = sb.substring(i, i + 1);
                String nextString = sb.substring(i + 1, i + 2);

                if (nowString.equals(nextString)) {
                    duplicateIndex.add(i);
                    duplicateIndex.add(i + 1);
                }
            }

            int forCount = 0;

            for (Integer duplicateIndexNum : duplicateIndex) {
                sb.deleteCharAt(duplicateIndexNum - forCount);
                forCount++;
            }

            forCount = 0;

            System.out.println("sb = " + sb);
        } while(!duplicateIndex.isEmpty());

        return sb.toString();
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";

        String solution = solution(cryptogram);
        System.out.println("solution = " + solution);
    }
}


