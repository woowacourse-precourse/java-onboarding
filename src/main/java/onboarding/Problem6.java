package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//문제 6번 기능 요구 사항
//1. 닉네임 2개를 비교해서 같은 글자 연속적으로 포함되는지 확인하는 함수
//2. 정답 리스트에 같은 이메일이 있는지 체크하는 함수
//3. 리스트를 오름차순으로 정렬하는 함수
//4. 각 닉네임을 돌면서 비교 함수에 넣고 같은 것이 있다면 정답 리스트에 넣는 함수

public class Problem6 {

    //기능 1
    public static boolean checkName(String name1, String name2) {

        int nameLength= 0;	//짧은 닉네임 길이
        String shortStr="";	//짧은 닉네임
        String longStr="";	//긴 닉네임
        boolean same=false;	//닉네임 같은지 여부

        if(name1.length()<name2.length())
        {
            nameLength=name1.length();
            shortStr=name1;
            longStr=name2;
        }
        else
        {
            nameLength=name2.length();
            shortStr=name2;
            longStr=name1;
        }

        for(int i=0;i<nameLength-1;i++) {
            String twoString=shortStr.substring(i,i+2);
            if(longStr.contains(twoString)) {
                same=true;
                break;
            }
            else
                continue;
        }

        return same;
    }

    //기능 2
    public static boolean checkEmail(List<String> emailList,String email) {

        boolean containEmail=emailList.contains(email);

        return containEmail;
    }

    //기능 3
    public static List<String> sortList(List<String> answer){
        Collections.sort(answer);
        return answer;
    }

    //기능 4
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer=new ArrayList<String>();

        for(int i=0;i<forms.size()-1;i++) {
            String name1=forms.get(i).get(1);

            for(int j=0;j<forms.size();j++) {

                if(i!=j) {
                    String name2=forms.get(j).get(1);
                    String email2=forms.get(j).get(0);

                    if(checkName(name1,name2)) {
                        if(!checkEmail(answer,email2)) {
                            answer.add(email2);
                        }
                        else
                            continue;
                    }
                    else
                        continue;
                }
            }
        }
        answer=sortList(answer);

        return answer;
    }
}
