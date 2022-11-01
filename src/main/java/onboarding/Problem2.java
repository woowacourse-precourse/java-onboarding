package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer answer = new StringBuffer(cryptogram);
        int crypt_flag = 1;
        int flag = 0;
        int string_len = cryptogram.length();
        int k=0;
        char dup = 'A';
        int idx[] = new int[1000];
        int idx_len = 0;
        int delt_count = 0;
        int count =0;
        while(crypt_flag == 1){
            flag = 0;
            crypt_flag = 0;
            idx_len = 0;
            delt_count = 0;
            string_len = answer.length();
            if(string_len == 0){
                break;
            }
            for(k=0;k<idx_len - 1;k++){
                idx[k] = -1;
            }

            for(k=1;k<string_len;k++){
                if(flag==1) {
                    if(dup != answer.charAt(k)){
                        idx[idx_len] = k - 1;
                        idx_len += 1;
                        flag = 0;
                    }
                }
                else{
                    if(answer.charAt(k) == answer.charAt(k-1)){
                        flag = 1;
                        crypt_flag = 1;
                        dup = answer.charAt(k);
                        idx[idx_len] = k - 1;
                        idx_len += 1;
                    }
                }
            }
            for(k=0;k<idx_len;k+=2){
                answer.delete(idx[k] - delt_count, idx[k+1] + 1 - delt_count);
                delt_count += idx[k+1] - idx[k] + 1;
            }
        }
        return answer.toString();
    }
}
