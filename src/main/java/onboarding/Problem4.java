package onboarding;

public class Problem4 {
    public static String solution(String word) {
        try{
            constraint4(word);
        } catch(Exception e){
            System.out.println("Problem4 exception : " + e.getMessage());
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < word.length(); i++) {
            char temp_char = word.charAt(i);
            if (temp_char >= 'A' && temp_char <= 'Z') {
                answer.append((char) ('Z' - (temp_char - 'A')));
            }else if (temp_char >= 'a' && temp_char <= 'z') {
                answer.append((char) ('z' - (temp_char - 'a')));
            }else{
                answer.append(temp_char);
            }
        }
        return answer.toString();
    }

    //제한사항을 검사하는 constraint
    static void constraint4(String word) throws Exception {
        if (word.length() < 1 || word.length() > 10000) {
            throw new Exception("문자열은 길이가 1 이상이고 1,000 이하이어야 한다.");
        }
    }
}
