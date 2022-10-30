package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = spellChanger(word);
        return answer;
    }

    static String spellChanger(String word) {
        StringBuilder sb = new StringBuilder();
        char[] spellArr = word.toCharArray();
        for (char spell : spellArr) {
            if (caseInspector(spell) == 1)
                sb.append((char) (155 - spell));
            else if (caseInspector(spell) == 0)
                sb.append((char) (219 - spell));
            else
                sb.append(spell);
        }

        return sb.toString();
    }

    static int caseInspector(char spell) {
        int result = -1;
        if (65 <= spell && spell <= 90)
            result = 1;
        else if (97 <= spell && spell <= 122)
            result = 0;
        return result;

    }
}
