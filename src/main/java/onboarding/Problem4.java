package onboarding;

public class Problem4 {
    public static final int ASCII_UPPER_A = 65;
    public static final int ASCII_LOWER_A = 97;
    public static final int ASCII_UPPER_M = 77;
    public static final int ASCII_LOWER_M = 109;
    public static final int ASCII_UPPER_N = 78;
    public static final int ASCII_LOWER_N = 110;
    public static final int ASCII_UPPER_Z = 90;
    public static final int ASCII_LOWER_Z = 122;

    public static char AToMConverter(char word) {
        int asciiValue = word;
        asciiValue = ASCII_UPPER_Z - (asciiValue - ASCII_UPPER_A);
        return (char)asciiValue;
    }

    public static char NToZConverter(char word) {
        int asciiValue = word;
        asciiValue = ASCII_UPPER_A + (ASCII_UPPER_Z - asciiValue);
        return (char)asciiValue;

    }

    public static char aTomConverter(char word) {
        int asciiValue = word;
        asciiValue = ASCII_LOWER_Z - (asciiValue - ASCII_LOWER_A);
        return (char)asciiValue;
    }

    public static char nTozConverter(char word) {
        int asciiValue = word;
        asciiValue = ASCII_LOWER_A + (ASCII_LOWER_Z - asciiValue);
        return (char)asciiValue;

    }

    public static String convertingWord(String word) {
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++)
        {
            if(wordArray[i] >= ASCII_UPPER_A && wordArray[i] <= ASCII_UPPER_M)
            {
                wordArray[i] = AToMConverter(wordArray[i]);
            }
            else if(wordArray[i] >= ASCII_UPPER_N && wordArray[i] <= ASCII_UPPER_Z)
            {
                wordArray[i] = NToZConverter(wordArray[i]);
            }
            else if(wordArray[i] >= ASCII_LOWER_A && wordArray[i] <= ASCII_LOWER_M)
            {
                wordArray[i] = aTomConverter(wordArray[i]);
            }
            else if(wordArray[i] >= ASCII_LOWER_N && wordArray[i] <= ASCII_LOWER_Z)
            {
                wordArray[i] = nTozConverter(wordArray[i]);
            }
        }
        return String.valueOf(wordArray);
    }

    public static String solution(String word) {
        String answer = convertingWord(word);
        return answer;
    }
}
