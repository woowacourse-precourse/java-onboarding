package onboarding;

public class Problem2 {
    static StringBuilder sb = new StringBuilder();
    static boolean checkModifyText;
    static boolean checkPre;
    static boolean checkCurrent;
    static boolean checkNotLowerCase;
    public static String solution(String cyptogram) {
        if (exceptionMethod(cyptogram)) {
            return cyptogram;
        }
        do {
            cyptogram = (cyptogram.length() >= 3 ? longTextDeduplication(cyptogram) : shortTextDuplication(cyptogram));
        } while (checkModifyText);
        return cyptogram;
    }
}