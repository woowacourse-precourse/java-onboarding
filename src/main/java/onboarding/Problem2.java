package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean flag = true;
        while (flag) {
            flag = false;
            String temp = "";
            char[] chars = answer.toCharArray();
            if (chars[0] != chars[1]) {
                temp = temp + chars[0];
            }
            for (int i=1; i < answer.length()-1; i++){
                if (chars[i-1] == chars[i] || chars[i] == chars[i+1]) {
                    flag = true;
                    continue;
                } else {
                    temp = temp + chars[i];
                }
            }
            if (chars[answer.length()-1] != chars[answer.length()-2]) {
                temp = temp + chars[answer.length() - 1];
            }

            answer = temp;
        }

        return answer;
    }
//    public static void main(String[] args) {
//        Problem2 prob = new Problem2();
//        String cryptogram = "browoanoommnaon";
////        System.out.println(cryptogram);
//        String result = prob.solution(cryptogram);
//        System.out.println(result);
//    }
}
