package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            byte num = (byte) a;


//                    대문자 알파벳일때
            if (num >= 65 && num <=90){
                int num2 = 155 -num  ;

                char num_to_char =  (char) num2;
                sb.append(num_to_char);

//                    소문자 알파벳일때
            }else if (num >= 97 && num <= 122){
                int num2 = 219 -num  ;

                char num_to_char =  (char) num2;
                sb.append(num_to_char);
            }else if (num ==32){
                int num2 = num;
                char num_to_char =  (char) num2;
                sb.append(num_to_char);
            }else{
                continue;
            }

        }
        System.out.println(sb.getClass().getName());
        String answer = sb.toString();
        return answer;
    }
}
