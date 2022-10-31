package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String arr[] = new String[forms.size()];
        int check[] = new int[forms.size()];
        int num=0;
        for(int i=0;i<forms.size();i++) {
            {
                arr[i]=forms.get(i).get(1);
            }
        }

        for(int i=0;i<forms.size()-1;i++){
            for(int j=0;j<arr[i].length()-1;j++){
                for(int w=i;w<forms.size()-1;w++) {
                    System.out.println( arr[w + 1].length() - 1);
                    if (arr[w + 1].indexOf(arr[i].charAt(j)) != -1 && arr[w + 1].indexOf(arr[i].charAt(j)) != arr[w + 1].length() - 1) {
                        if (arr[i].charAt(j + 1) == arr[w+1].charAt(arr[w + 1].indexOf(arr[i].charAt(j)) + 1)) {
                            check[i]++;
                            check[w + 1]++;
                            break;
                        }
                    }
                }
            }
        }


        for(int i=0;i<forms.size();i++){
            if(check[i]!=0){
                answer.add(forms.get(i).get(0));
            }
        }

       Collections.sort(answer,String.CASE_INSENSITIVE_ORDER);

        return answer;
    }

}
