package onboarding;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // TreeSet: set 오름차순 Hashset : set 선언
        TreeSet<String> result = new TreeSet<>();
        //여기서 i와 j는 이중리스트 몇 열인지 셀때 사용햇음
        for(int i=0 ; i<forms.size()-1 ; i++){
            for(int j=i+1 ; j<forms.size() ; j++){
                //이중리스트 2번째(index:1) 닉네임만 비교할꺼임
                String[] a = forms.get(i).get(1).split("");
                String[] b = forms.get(j).get(1).split("");
                //여기서 k와 l은 선택된 닉네임중 어떤게 똑같을지 비교하기위해서 사용하였음
                for(int k=0 ; k<a.length-1 ; k++){
                    for(int l=0 ; l<b.length-1 ; l++){
                        //for문 String은 비교할때 equals 쓴다. 기억하자.
                        if (a[k].equals(b[l])){
                            if(a[k+1].equals(b[l+1])){
                                result.add(forms.get(i).get(0));
                                result.add(forms.get(j).get(0));
                            }
                        }

                    }
                }

            }
        }
        List<String> answer = List.of("answer");
        //set 함수는 get을 사용할수 없다 이점 꼭 참고하자
        List<String> a = new ArrayList<>(result);
        answer = a;

        return answer;
    }
}
