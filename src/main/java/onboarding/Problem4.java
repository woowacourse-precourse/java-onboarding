package onboarding;


/*
* 1. 65~90인지 확인 // 72.5, 109.5
* 2. 그렇다면, c -  or 97~122  12.5
* */



public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (c < 65 || (c > 90 && c < 96) || c > 122) {
                answer.append(c);
            } else answer.append(reverseCharacter(c));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
//        System.out.println(reverseCharacter('a'));
//        System.out.println(reverseCharacter('m'));
//        System.out.println(reverseCharacter('n'));
//        System.out.println(reverseCharacter('M'));
//        System.out.println(reverseCharacter('N'));
//        System.out.println();
    }

    private static char reverseCharacter(char c) {
        System.out.println("c = " + (int)c);
        double distance = c <= 90 ? 77.5 - c : 109.5 - c;
        System.out.println("distance = " + distance);

        return (char) (c + (int) (distance*2));
    }
}
