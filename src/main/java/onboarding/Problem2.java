package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    // 삭제할 문자 인덱스 반환
    private static List<Integer> deleteIdx(String input){
        char[] chars = input.toCharArray();
        List<Integer> delete = new ArrayList<>();
        for (int i=1; i<chars.length; i++){
            if (chars[i-1]==chars[i]) delete.add(i);
        }
        return delete;
    }
}
