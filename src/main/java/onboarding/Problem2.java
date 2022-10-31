package onboarding;

public class Problem2 {
    /**
     * 입력 문자열에 연속으로 같은 글자를 삭제, 단어에 연속적으로 일치하는 글자가 없을때까지 반복하는 함수
     * @param cryptogram
     * @return preprocessed word
     */
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        // 연속적으로 일치하는 문자가 있는지에 대한 변수
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
