package problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new TreeSet<>();

        for(int i=0; i<forms.size(); i++) {
            String crewEmail = forms.get(i).get(0);
            String crewNickName = forms.get(i).get(1);
            
            for (int j=0; j<crewNickName.length()-1; j++) {
                    String nextCrewEmail = forms.get(j).get(0);
                    String nextCrewNickName = forms.get(j).get(1);
                    if(nextCrewNickName.contains(crewNickName.substring(j, j+2))) {
                        result.add(crewEmail);
                        result.add(nextCrewEmail);
                    }
            }
        }
        return new ArrayList<>(result);
    }
	
}
