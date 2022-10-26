package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String prevString = cryptogram;
        String nextString = prevString.replaceAll("[a-z]{3}", ".");

        System.out.println("Prev String = " + prevString);
        System.out.println("Next String = " + nextString);

//        while (prev != next) {
//            prev = next;
//            next = prev.replaceAll("[a-z]{2,}", "");
//            System.out.println(next);
//        }

        String answer = nextString;
        return answer;
    }
}
