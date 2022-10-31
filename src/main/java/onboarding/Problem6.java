package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int[][] beenHere = new int[forms.size()][forms.size()]; // 중복이 이미 확인됐는지 체크

        for(int i= 0; i<forms.size()-1; i++){
            String name= forms.get(i).get(1);  //기준 크루 선정
            String mail= forms.get(i).get(0);

            for(int j = 0; j<name.length()-1;j++){
                String sub_name=name.substring(j,j+2); // 그 크루의 이름 2글자단위 파싱(기준문자열)
                for(int k=i+1; k<forms.size();k++){ // 기준 크루의 기준문자열과 후순위 크루들 이름의 중복여부 비교
                    if(beenHere[i][k]==1) continue; // 이미 중복이 확인된 멤버는 검사 면제
                    if(k==i) continue;

                    String toCompare=forms.get(k).get(1);
                    String hisMail=forms.get(k).get(0);

                    if(toCompare.contains(sub_name)){
                        answer.add(mail);// 중복발견 시, 메일 수집
                        answer.add(hisMail);
                        beenHere[i][k]=1;
                        beenHere[k][i]=1;
                    }
                }
            }
        }

        HashSet<String> mailSet= new HashSet<>(); //해쉬셋으로 중복제거
        for(String e: answer){
            mailSet.add(e);
        }
        ArrayList<String> outcome= new ArrayList<>(mailSet); //리스트로 재변환 후 정렬
        outcome.sort(Comparator.naturalOrder());

        return outcome;
    }

  /*  public static void main(String[] args){
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }*/
}
