package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 1. 제시된 기준에 따라 mapping table을 구성함
        int[] mapTable = buildMapTable();

        // 2. 구성한 mapping table을 참조하여 문자열을 변환함
        answer = convertStr(word, mapTable);

        return answer;
    }

    // 문자열 변환에 사용할 mapping table을 구성
    private static int[] buildMapTable() {
        int[] mapTable = new int[26];
        for(int i=0 ; i<26 ; i++)
            mapTable[i] = 25-i;
        return mapTable;
    }

    // 구성한 mapping table을 참조하여 문자열을 변환
    private static String convertStr(String word, int[] mapTable) {
        final int UPPER = 65; // 'A'의 ASCII 코드
        final int LOWER = 97; // 'a'의 ASCII 코드
        StringBuilder sb = new StringBuilder(); // 변환한 문자열을 저장

        char[] letters = word.toCharArray();
        for(char c : letters) {
            if(c == ' ') sb.append(c);
            else if(Character.isUpperCase(c)) sb.append((char)(UPPER+mapTable[(int)c-UPPER]));
            else sb.append((char)(LOWER+mapTable[(int)c-LOWER]));
        }

        return sb.toString();
    }
}
