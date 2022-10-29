package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /***
     * 문자를 반대로 변환(청개구리 사전)
     * @param x
     * @param isLower
     * @return
     */
    private static char getaChar(char x, boolean isLower) {
        char[] table = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        // 대문자로 바꿔서 변환 수행
        x = Character.toUpperCase(x);

        int i=0;
        boolean check = false;
        while(!check) {
            if(x == table[i]) check=true;
            i++;
        }

        // 청개구리 문자 = 사전의 길이 - 원래 문자의 위치
        if(isLower)
            return Character.toLowerCase(table[table.length-i]);
        else return table[table.length-i];
    }
}
