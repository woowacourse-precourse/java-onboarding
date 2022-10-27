package onboarding;

public class Problem4 {
    private static final int num_A = 'A';
    private static final int num_Z = 'Z';
    private static final int num_a = 'a';
    private static final int num_z = 'z';

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            int charNum = word.charAt(i);
            if (charNum > num_a && charNum < num_z)
                charNum = num_z - (charNum-num_a);
            else if (charNum > num_A && charNum <num_Z)
                charNum = num_Z - (charNum-num_A);
            answer.append((char) charNum);
        }

        return answer.toString();
    }
}
