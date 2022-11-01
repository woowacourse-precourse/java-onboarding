package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.String;

public class Problem6 {

    static int [] arr=new int[10001];
    public static void go(String [] Str,String str,int check,int now) {

        for (int i = 0; i < str.length() - 1; i++) {
            String ss = "";
            ss += (char)(str.charAt(i));
            ss+=(char)str.charAt(i + 1);

            for (int j = now+1; j < check; j++) { // 체크까지 간
                for (int k = 0; k < Str[j].length() - 1; k++) {

                    String ss2 = "";
                    ss2+=(char)Str[j].charAt(k);
                    ss2+=(char)Str[j].charAt(k+1);


                    if (ss.compareTo(ss2)==0) {
                        arr[i] = 1;
                        arr[j]=1;
                        break;
                    }

                }
            }
        }
    }


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


        for(int i=0;i<check;i++)
        { // str에 모든 한글 이름
            go(str,str[i],check,i);
        }

        for(int i=0;i<check;i++)
        {
            if(arr[i]==1)
            {
                String ppp="";
                ppp+=str2[i];
                answer.add(ppp);
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
