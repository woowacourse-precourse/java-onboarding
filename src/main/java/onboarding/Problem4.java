package onboarding;

public class Problem4 {
    public static String solution(String word) {
        try {
            if(!isIncludeAlpa(word)) {
                throw new Exception("제한사항에 위반되는 문자열입니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String answer = "";
        for (int index = 0; index < word.length(); index++) {
            answer+=changeAlpa(word.charAt(index));
        }
        return answer;
    }

    private static boolean isIncludeAlpa(String word) {
        if(word.length()<1 || word.length()>1000) return false;

        for (int i = 0; i < word.length(); i++) {
            char alpa = word.charAt(i);
            if (alpa==' ') continue;
            if((alpa<'a'||alpa>'z')&&(alpa<'A'||alpa>'Z')) return false;
        }

        return true;
    }

    private static char changeAlpa(char alpa) {
        if(alpa == ' ') return ' ';
        boolean isUpperCase = Character.isUpperCase(alpa);

        char alpaToUpperCase = Character.toUpperCase(alpa);

        char switchedAlpa = (char) (155 - alpaToUpperCase);

        if(!isUpperCase)
            switchedAlpa=Character.toLowerCase(switchedAlpa);

        return switchedAlpa;
    }
}
