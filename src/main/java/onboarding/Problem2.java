package onboarding;

public class Problem2 {
    static String answer;

    public static String solution(String cryptogram) {
        answer = cryptogram;
        deleteDuplicate(answer);
        return answer;
    }
    /*
        duplicateWord가 비어있는 문자열("")이라면
        연속적인 알파벳이 없다.
         */
    public static void deleteDuplicate(String input) {
        String duplicateWord = findDuplicate(input);
        if (!duplicateWord.equals("")) {
            answer = answer.replaceAll(duplicateWord, "");
            deleteDuplicate(answer);
        }
    }
    /*
         단어 하나를 시작으로
         연속적인 단어의 개수만큼
         문자열로 만드는 과정
         ex) 단어 "a"가 2개가 중복된다면 문자열 "aa"로 반환
        그러나 단어의 개수가 1개라면 중복된 단어가 아니어서 빈 문자열 ""을 반환
    */
    public static String findDuplicate(String answer){
        char word; //연속이 될 단어의 첫 번째
        StringBuilder sb;
        for (int startPoint = 0 ; startPoint< answer.length()-1 ;startPoint++){
            word = answer.charAt(startPoint);
            sb = new StringBuilder();
            sb.append(String.valueOf(word).repeat(getDuplicateLength(word, startPoint)));
            if (sb.length()>=2) return sb.toString();
        }
        return "";
    }
    /*
    중복되는 문자의 길이
    중복되지 않을 시에 길이 1을 반환
     */
    private static int getDuplicateLength(char word, int startPoint) {
        int duplicateLength = 1;
        for (int comparePoint = startPoint +1; comparePoint< answer.length(); comparePoint++){
            if (answer.charAt(comparePoint)== word){
                duplicateLength++;
            }else if (answer.charAt(comparePoint)!=word) {
                break;
            }
        }
        return duplicateLength;
    }

}
