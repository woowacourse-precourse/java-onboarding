package onboarding;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";

        //엄마말씀 반대로 변환 기능
        for (int i = 0; i < word.length(); i++) {

            //공백인 경우
            if (word.charAt(i) == ' ') {
                //System.out.print(" ");
                answer = answer+" ";
                continue;
            }


            int N = (int)word.charAt(i);
            int A=-1, Z=-1, result=-1;
            //대문자인 경우
            if (N < 97){
                A = 65;
                Z = 90;
            }else{
                A = 97;
                Z = 122;
            }
            result = Z-(N-A);

            answer = answer + String.valueOf((char)result);
        }

        return answer;
    }
}
