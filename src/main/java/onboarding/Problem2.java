package onboarding;

public class Problem2 {
    static boolean[] delete;
    static int strLength;

    public static String solution(String cryptogram) {
        strLength = cryptogram.length();

        delete = new boolean[strLength];
        for(int i =1; i < strLength; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                delete[i] = true;
                delete[i-1] = true;

                ExpandDuplication(i-1, i, cryptogram);
            }
        }

        //살아남은 글자 체크
        String answer = "";
        for(int i=0; i < strLength; i++){
            if(!delete[i])
                answer += cryptogram.charAt(i);
        }

        return answer;
    }

    public static void ExpandDuplication(int left, int right, String word){
        //왼쪽 삭제되지 않은 것 찾기
        while(true){
            if(left < 0)
                return;

            if(!delete[left])
                break;

            left--;
        }

        //오른쪽 삭제되지 않은 것 찾기
        while(true){
            if(right >= strLength)
                return;

            if(!delete[right])
                break;

            right++;
        }

        //왼쪽과 오른쪽의 문자가 같으면 또 체크
        if(word.charAt(left) == word.charAt(right)){
            delete[left] = true;
            delete[right] = true;

            ExpandDuplication(left, right, word);
        }

    }

}
