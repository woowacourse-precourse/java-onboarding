package onboarding;

public class Problem2 {


    public static char[] removeWhitespace(char[] cryptoArray) {
        return String.valueOf(cryptoArray).replaceAll("\\s","").toCharArray();
    }

    public static String deDuplicate(String cryptogram) {
        char[] cryptoArray = cryptogram.toCharArray();
        int duplicateFlag = 1;
        while(duplicateFlag != 0)
        {
            if(cryptoArray.length == 0) break;
            duplicateFlag = 0;
            int targetChar = cryptoArray[0];
            for(int i = 0; i < cryptoArray.length - 1; i++)
            {
                if(targetChar != cryptoArray[i + 1])
                {
                    targetChar = cryptoArray[i + 1];
                }
                else
                {
                    cryptoArray[i] = ' ';
                    cryptoArray[i + 1] = ' ';
                    duplicateFlag = 1;
                }
            }
            cryptoArray = removeWhitespace(cryptoArray);
        }
        return String.valueOf(cryptoArray);
    }

    public static String solution(String cryptogram) {
        String answer = deDuplicate(cryptogram);
        return answer;
    }
}
