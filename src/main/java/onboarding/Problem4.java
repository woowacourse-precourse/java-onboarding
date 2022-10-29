package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean isIncludeAlpa(String word) {
        if(word.length()<1 || word.length()>1000) return false;

        for (int i = 0; i < word.length(); i++) {
            char alpa = word.charAt(i);
            if((alpa<'a'||alpa>'z')&&(alpa<'A'||alpa>'Z')) return false;
        }

        return true;
    }


}
