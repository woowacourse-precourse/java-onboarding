package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeOverlappedCharacters(cryptogram);
        return answer;
    }
    public static String removeOverlappedCharacters(String cryptogram){
        StringBuilder targetString = new StringBuilder(cryptogram);
        while (true){
            int overlappedIndex = getOverlappedIndex(targetString.toString());
            if (overlappedIndex == -1)
                break ;
            targetString.delete(overlappedIndex, overlappedIndex+2);
        }
        return targetString.toString();
    }
    public static int getOverlappedIndex(String cryptogram){
        for (int i = 0 ; i < cryptogram.length() - 1 ; i++){
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1))
                return i;
        }
        return -1;
    }
}
