package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        char[] wd = word.toCharArray();
        char[] result = new char[wd.length];
        for (int i = 0; i < word.length(); i++) {
            char ch = wd[i];
            if (ch >= 'A' && ch <= 'Z') {
                int diff = (int) (155 - ch);
                result[i] = (char) diff;
            } else if (ch >= 'a' && ch <= 'z') {
                int diff = (int) (219 - ch);
                result[i] = (char) diff;
            } else {
                result[i] = ' ';
            }
        }
        answer = new String(result);
        return answer;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String word = sc.nextLine();
//        String answer;
//        char[] wd = word.toCharArray();
//        char[] result = new char[wd.length];
//        for (int i = 0; i < word.length(); i++) {
//            char ch = wd[i];
//            if (ch >= 'A' && ch <= 'Z') {
//                int diff = (int) (155 - ch);
//                result[i] = (char) diff;
//            } else if (ch >= 'a' && ch <= 'z') {
//                int diff = (int) (219 - ch);
//                result[i] = (char) diff;
//            }
//            else{
//                result[i] = ' ';
//            }
//        }
//        answer = new String(result);
//        System.out.println(answer);
//    }
}
