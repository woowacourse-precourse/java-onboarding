package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        System.out.println("answer = " + answer);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char charWord = word.charAt(i);

            if (charWord == ' ') {
                sb.append(charWord);
            } else if (charWord == 'a') {
                charWord = 'z';
                sb.append(charWord);
            } else if (charWord == 'b') {
                charWord = 'y';
                sb.append(charWord);
            } else if (charWord == 'c') {
                charWord = 'x';
                sb.append(charWord);
            } else if (charWord == 'd') {
                charWord = 'w';
                sb.append(charWord);
            } else if (charWord == 'e') {
                charWord = 'v';
                sb.append(charWord);
            } else if (charWord == 'f') {
                charWord = 'u';
                sb.append(charWord);
            } else if (charWord == 'g') {
                charWord = 'T';
                sb.append(charWord);
            } else if (charWord == 'h') {
                charWord = 's';
                sb.append(charWord);
            } else if (charWord == 'i') {
                charWord = 'r';
                sb.append(charWord);
            } else if (charWord == 'j') {
                charWord = 'q';
                sb.append(charWord);
            } else if (charWord == 'k') {
                charWord = 'p';
                sb.append(charWord);
            } else if (charWord == 'l') {
                charWord = 'o';
                sb.append(charWord);
            } else if (charWord == 'm') {
                charWord = 'n';
                sb.append(charWord);
            } else if (charWord == 'n') {
                charWord = 'm';
                sb.append(charWord);
            } else if (charWord == 'o') {
                charWord = 'l';
                sb.append(charWord);
            } else if (charWord == 'p') {
                charWord = 'k';
                sb.append(charWord);
            } else if (charWord == 'q') {
                charWord = 'j';
                sb.append(charWord);
            } else if (charWord == 'r') {
                charWord = 'i';
                sb.append(charWord);
            } else if (charWord == 's') {
                charWord = 'h';
                sb.append(charWord);
            } else if (charWord == 't') {
                charWord = 'g';
                sb.append(charWord);
            } else if (charWord == 'u') {
                charWord = 'f';
                sb.append(charWord);
            } else if (charWord == 'v') {
                charWord = 'e';
                sb.append(charWord);
            } else if (charWord == 'w') {
                charWord = 'd';
                sb.append(charWord);
            } else if (charWord == 'x') {
                charWord = 'c';
                sb.append(charWord);
            } else if (charWord == 'y') {
                charWord = 'b';
                sb.append(charWord);
            } else if (charWord == 'z') {
                charWord = 'a';
                sb.append(charWord);
            }
        }

        System.out.println("sb.toString() = " + sb.toString());
//        "R olev blf"
        return answer;
    }

    public static void main(String[] args) {
        solution("i love you");
    }
}
