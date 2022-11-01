package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean isChange = true;
        String newCytogram = cryptogram;

        while (isChange) {
            isChange = false;
            char[] charArray = newCytogram.toCharArray();
            char overlapChar = ' ';
            for(int i = 0; i < charArray.length; i++) {

                if(charArray[i] == overlapChar) {
                    charArray[i] = '_';
                    charArray[i - 1] = '_';
                    isChange = true;
                }

                else overlapChar = charArray[i];
            }

            newCytogram = String.valueOf(charArray).replace("_", "");
            System.out.println(newCytogram);
        }
        return newCytogram;
    }
}
