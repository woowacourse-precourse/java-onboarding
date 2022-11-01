/*----------------------------------------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. 친구 관계의 성립을 edge, 사용자들을 node로 보면 graph 자료구조를 활용할 수 있음
 *   2. String 형식의 사용자 명을 node의 값으로 삼아야 하므로 key : value 쌍을 갖는 map 자료구조를 이용하여 graph 자료구조를 구현
 *   3. friends와 visitors 리스트의 모든 원소를 loop 하며 스캔하여 사용자 List에 누락이 없도록 주의
 *   4. 사용자를 전부 추가한 후 다시 friends List를 loop 돌면서 edge 상태를 저장
 *   5. 완성된 Graph를 참조하여 user 중심에서 각 사용자들의 Score를 계산
 *   6. visitors List를 조회하여 다시 Score에 가산
 *   7. 이미 친구인 경우 Score를 0으로 하며 자기 자신은 List에서 삭제
 *   8. map 자료구조만으로는 정렬을 할 수 없으므로 Map.entry를 활용하여 compare 기준을 작성하고 정렬
 *   9. 조건에 해당하는 사용자들의 이름을 List로 만들어 반환
 *   10. 코드의 길이가 길어지는 관계로 가독성을 위해 가급적 분리할 수 있는 메서드는 분리
 *---------------------------------------------------------------------------------------*/
package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;

public class Problem7 {
	static HashMap<String, List<String>> Fill_Graph(HashMap<String, List<String>> Graph, List<List<String>> friends){
        List<String> temp_list;

        for (List<String> l : friends){
            if (!Graph.get(l.get(0)).contains(l.get(1))){
                temp_list = new ArrayList<>(Graph.get(l.get(0)));
                temp_list.add(l.get(1));
                Graph.replace(l.get(0), temp_list);
            }
            if (!Graph.get(l.get(1)).contains(l.get(0))){
                temp_list = new ArrayList<>(Graph.get(l.get(1)));
                temp_list.add(l.get(0));
                Graph.replace(l.get(1), temp_list);
            }
        }
		return Graph;
	}
	
	static HashMap<String, Integer> Fill_Score(HashMap<String, Integer> Score, HashMap<String, List<String>> Graph, String user, List<String> visitors){
        for (String fr : Graph.get(user)){
            for (String fr_of_fr : Graph.get(fr)){
                Score.put(fr_of_fr, Score.get(fr_of_fr) + 10);
            }
        }

        for (String vst : visitors){
            Score.put(vst, Score.get(vst) + 1);
        }
		
        for (String fr : Graph.get(user)){

            Score.put(fr, 0);
        }
        Score.remove(user);

		return Score;
	}

	static List<String> Sort_and_Filter(HashMap<String, Integer> Score){
        List<String> Recommend = new ArrayList<>();

        List<Entry<String, Integer>> score_entry_list = new ArrayList<Entry<String, Integer>>(Score.entrySet());
        Collections.sort(score_entry_list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                if (obj1.getValue() == obj2.getValue()) //점수가 같을 때 이름순
                    return obj1.getKey().compareTo(obj2.getKey());
                else
                    return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        int count = 0;
        for (Entry<String, Integer> entry : score_entry_list){
            if (entry.getValue() > 0 && count <= 5) {
                count++;
                Recommend.add(entry.getKey());
            }
        }
		return Recommend;
	}

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> Graph = new HashMap<>();
		HashMap<String, Integer> Score = new HashMap<>();
        List<String> temp_list;

        for (List<String> l : friends) {
			for (int i = 0; i < 2; i++) {
				Graph.put(l.get(i), new ArrayList<String>());
				Score.put(l.get(i), 0);
			}
        }

        for (String str : visitors) {
			Graph.put(str, new ArrayList<String>());
			Score.put(str, 0);
        }

		Graph = Fill_Graph(Graph, friends);
		Score = Fill_Score(Score, Graph, user, visitors);

        List<String> answer = Sort_and_Filter(Score);
        return answer;
    }
}
