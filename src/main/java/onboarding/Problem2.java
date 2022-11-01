package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        char[] str = cryptogram.toCharArray();
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean flag = true;
        int check = 0;
        while (flag) {
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i - 1) == sb.charAt(i)) {
                    sb.delete(i - 1, i + 1);
                    check = 1;
                }
            }
            if (check != 1) {
                flag = false;
            }
            check = 0;
        }
        answer = sb.toString();
        return answer;
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String cryptogram = sc.nextLine();
//        String result;
//
//        result = solution(cryptogram);
//        System.out.println(result);
//    }
}
