package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(char c: word.toCharArray()) {
            String charType = checkAlphabet((int)c);
            if(!charType.equals("NOTALPHABET")) {
                answer.append(changeLetter((int)c, charType));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    public static String checkAlphabet(int asciiNum) {
        if(asciiNum >= (int)'A' && asciiNum <= (int)'Z') {
            return "UPPERCASE";
        }
        if(asciiNum >= (int)'a' && asciiNum <= (int)'z') {
            return "LOWERCASE";
        }
        return "NOTALPHABET";
    }

    public static char changeLetter(int asciiNum, String characterType) {
        int total = 0;
        if (characterType.equals("UPPERCASE")) {
            total = (int)'A' + (int)'Z';
        }
        if(characterType.equals("LOWERCASE")){
            total = (int)'a' + (int)'z';
        }
        return (char)(total - asciiNum);
    }
}
