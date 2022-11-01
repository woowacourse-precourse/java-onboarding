package onboarding;

public class Problem2 {

    public static StringBuilder deleteDuplicate(StringBuilder str){
        int firstIndex = checkDuplicate(str);
        int sum = 0;
        if(firstIndex!=-1){
            for(int i = firstIndex+1; i < str.length(); i++){ // 연속된 문자의 마지막 index 찾기
                if (str.charAt(firstIndex) == str.charAt(i))
                    sum+=1;
                else break;
            }
            str.delete(firstIndex, firstIndex+sum+1); // 시작 index부터 마지막 index까지 문자삭제
        }else return str;
        return deleteDuplicate(str); // 연속된 문자가 없을때까지
    }

    public static int checkDuplicate(StringBuilder str){
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return i; // 연속된 문자가 있다면 해당 문자가 시작되는 index return
        }return -1; // 연속되지 않는다면 -1 return
    }
    public static String solution(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);
        String answer = String.valueOf(deleteDuplicate(str));
        return answer;
    }
}