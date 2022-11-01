package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.String;

public class Problem6 {

        public static List<String> solution(List<List<String>> forms) {

            String [] str= new String[10001];
            String [] str2= new String[10001];

            //List<String> answer = List.of("answer");
            List<String> answer= new ArrayList<String>();

            int check=0;
            int check2=0;
            for(int i=0;i<forms.size();i++)
            {
                for(int j=0;j<forms.get(i).size();j++) {
                    if (j ==1) {
                        str[check] = forms.get(i).get(j);
                        check++;
                    }
                    else if(j==0)
                    {
                        str2[check2]=forms.get(i).get(j);
                        check2++;
                    }
                }
            }

            return answer;
    }
}
