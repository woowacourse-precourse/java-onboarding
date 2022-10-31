package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 엄마 사전 대문자
        char[] mom_arr_up = new char[26];
        for(int i=0; i<26; i++){
            mom_arr_up[i] = (char)(65 + i);
        }
        // 엄마 사전 소문자
        char[] mom_arr_lo = new char[26];
        for(int i=0; i<26; i++){
            mom_arr_lo[i] = (char)(97 + i);
        }
        // 청개구리 사전 대문자
        char[] ch_arr_up = new char[26];
        for(int i=0; i<26; i++){
            ch_arr_up[i] = (char)(90 - i);
        }
        // 청개구리 사전 소문자
        char[] ch_arr_lo = new char[26];
        for(int i=0; i<26; i++){
            ch_arr_lo[i] = (char)(122 - i);
        }
        // 입력받은 문자를 배열로 변환
        char[] arr = word.toCharArray();
        // 배열의 문자를 청개구리 사전으로 변환
        for(int i=0; i<arr.length; i++){
            // 대문자의 경우
            for(int j=0; j<26; j++){
                if(arr[i] == mom_arr_up[j]){
                    arr[i] = ch_arr_up[j];
                    // 같은 알파벳을 찾았을 때 변환 후 if문 종료
                    break;
                }
            }
            // 소문자의 경우
            for(int j=0; j<26; j++){
                if(arr[i] == mom_arr_lo[j]){
                    arr[i] = ch_arr_lo[j];
                    // 같은 알파벳을 찾았을 때 변환 후 if문 종료
                    break;
                }
            }
        }
        // answer에 정답 입력
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        return answer;
    }
}
