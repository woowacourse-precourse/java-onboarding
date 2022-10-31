package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 1. 제시된 기준에 따라 mapping table을 구성함
        int[] mapTable = buildMapTable();

        return answer;
    }

    // 문자열 변환에 사용할 mapping table을 구성
    private static int[] buildMapTable() {
        int[] mapTable = new int[26];
        for(int i=0 ; i<26 ; i++)
            mapTable[i] = 25-i;
        return mapTable;
    }
}