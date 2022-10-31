package onboarding;

public class Problem4 {

    public static String solution(String word) {
        Problem4 pb4 = new Problem4();
        StringBuilder answer = new StringBuilder();
        for(char c: word.toCharArray()) {
            String charType = pb4.checkAlphabet((int)c);
            if(!charType.equals("NOTALPHABET")) {
                answer.append(pb4.changeLetter((int)c, charType));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    public String checkAlphabet(int asciiNum) {
        if(asciiNum >= (int)'A' && asciiNum <= (int)'Z') {
            return "UPPERCASE";
        }
        if(asciiNum >= (int)'a' && asciiNum <= (int)'z') {
            return "LOWERCASE";
        }
        return "NOTALPHABET";
    }

    public char changeLetter(int asciiNum, String characterType) {
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
