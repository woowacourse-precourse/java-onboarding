package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms){

        List<String> answer = new ArrayList<>();


        for(int i=0; i<forms.size(); i++){
            List<String> emailAndName = forms.get(i);
            String email = emailAndName.get(0);
            String name = emailAndName.get(1);

            for(int j=i+1; j<forms.size(); j++){
                List<String> otherEmailANdName = forms.get(j);

                String otherEmail = otherEmailANdName.get(0);
                String otherName = otherEmailANdName.get(1);

                int m = name.length();
                int n = otherName.length();
                int[][] compareBoard = new int[m+1][n+1];

                for(int k=0; k<=m; k++){
                    for(int l=0; l<=n; l++){
                        if(k==0 || l == 0){
                            compareBoard[k][l] = 0;
                        }
                        else if(name.charAt(k-1) == otherName.charAt(l-1)){
                            compareBoard[k][l] = compareBoard[k-1][l-1] + 1;

                            if (compareBoard[k][l] >= 2){
                                if (!answer.contains(email)){
                                    answer.add(email);
                                }
                                if (!answer.contains(otherEmail)){
                                    answer.add(otherEmail);
                                }
                            }
                        }
                        else{
                            compareBoard[k][l] = 0;
                        }
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

}

