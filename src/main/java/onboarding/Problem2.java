package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean isChange = true;
        String newCytogram = cryptogram;
        // 더이상 중복되는 문자가 없을 때 까지 반복
        while (isChange) {
            isChange = false;
            char[] charArray = newCytogram.toCharArray();
            char overlapChar = ' ';
            for(int i = 0; i < charArray.length; i++) {
                // 이전 문자와 중복되면 '_'로 변환
                if(charArray[i] == overlapChar) {
                    charArray[i] = '_';
                    charArray[i - 1] = '_';
                    isChange = true;
                }
                // 중복되지 않으면 overlapChar에 새로운 문자를 넣음
                else overlapChar = charArray[i];
            }
            // '_' 로 변환했던 문자들 제거
            newCytogram = String.valueOf(charArray).replace("_", "");
            System.out.println(newCytogram);
        }
        return newCytogram;
    }
}
