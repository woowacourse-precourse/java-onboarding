package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        ArrayList<String> answer = new ArrayList<String>();

        for (int i=0;i<forms.size();i++){ // 변수 i, j를 이용하여 두 개의 pair를 compare
            List<String> element = forms.get(i);
            String str1 = element.get(1);

            List<String> strsub1 = new ArrayList<String>(); // 길이가 2인 substr의 list
            for(int ii=0;ii<str1.length() -1;ii++){
                strsub1.add(str1.substring(ii,ii+2));
            }

            for (int j=i+1;j<forms.size();j++) {
                List<String> element2 = forms.get(j);
                String str2 = element2.get(1);

                List<String> strsub2 = new ArrayList<String>(); // 길이가 2인 substr의 list
                for (int jj = 0; jj < str2.length() - 1; jj++) {
                    strsub2.add(str2.substring(jj, jj + 2));
                }

                Set<String> common = new HashSet<>(strsub1); // 교집합이 있다면, 연속적 포함으로 간주
                common.retainAll(strsub2);

                if (!common.isEmpty()) {
                    answer.add(element.get(0));
                    answer.add(element2.get(0));
                }
            }
        }
        HashSet<String> hashSet = new HashSet<>(answer);
        ArrayList<String> answer2 = new ArrayList<>(hashSet);
        Collections.sort(answer2);
        System.out.println(answer2);

        answer = answer2;

        return answer;
    }
}
