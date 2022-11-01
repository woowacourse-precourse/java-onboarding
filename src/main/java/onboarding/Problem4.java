package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // String의 concat 효율을 높이기 위해 sb 선언.
        StringBuilder sb = new StringBuilder();

        // word 길이에 따라 예외처리한다.
        if (word == null || word.length() < 1 || word.length() > 1000){
            System.out.println("word 길이를 1~1000 사이로 해주세요.");
            // error 임을 알리고 종료한다.
            System.exit(1);
        }

        // word에 각 글자별로 비교한다.
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            // word의 공백은 생략한다.
            if(ch != ' ')
            {
                ch = charChange(ch);
            }
            sb.append(ch);
        }

        // 결과를 String으로 return한다.
        answer = sb.toString();
        return answer;
    }

    public static char charChange(char c) {
        // 소문자인 경우 (ASCII 97 ~ 122)
        if (c >= 'a' && c <= 'z') {
            // 25 - ch + 'a' * 2
            return (char) (25 - c + ('a' * 2));
        }

        // 대문자인 경우 (ASCII 065 ~ 090)
        if (c >= 'A' && c <= 'Z') {
//        System.out.println(('A' - 'Z')); // -25
//        System.out.println(('B' - 'Y')); // -23
//        System.out.println(('Y' - 'B')); // 23
//        System.out.println(('Z' - 'A')); // 25

            // 식 : 25 - ch + 'A' * 2 (귀납)
            return (char) (25 - c + ('A' * 2));
        }

        // 나머지 문자들은 그대로 return한다.
        return c;
    }

}
