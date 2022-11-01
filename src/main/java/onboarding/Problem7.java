package onboarding;

import java.util.*;

public class Problem7 {

    public static HashSet<String>  collectWholeMember(List<List<String>> friends){
        HashSet<String> totalMemberSet = new HashSet<>();
        for(List<String> friend: friends){
            for(int i=0; i<2; i++){
                totalMemberSet.add(friend.get(i));
            }
        }
        return totalMemberSet;
    }

    public static int[][] relationshipGraph(List<String> memberList, List<List<String>> friends){
        int[][] graph = new int[memberList.size()][memberList.size()];

        for(List<String> connection: friends){
            int mem1= memberList.indexOf(connection.get(0));
            int mem2= memberList.indexOf(connection.get(1));
            graph[mem1][mem2]=1;
            graph[mem2][mem1]=1;
        }
        return graph;
    }

    public static List<Integer> calcPoint(int[][] matrix,List<String> visitors, List<String> memberList, String user){
        List<Integer> result = new ArrayList<>();   // 최종 점수 계산하여 저장하는 리스트
        int user_idx=memberList.indexOf(user);

        //함께 아는 친구 점수(10점짜리)
        for(int col=0; col< matrix[0].length;col++){
            if(col== user_idx) continue;
            if(matrix[col][user_idx]==1){
                for(int row=0; row<matrix[0].length;row++){
                    if(row==col || row==user_idx) continue;
                    if(matrix[col][row]==1) matrix[row][row]+=10;
                }
            }
        }

        //리스트에 10점짜리 점수 선반영
        for(int i =0; i<matrix[0].length; i++){
            result.add(matrix[i][i]);
        }

        //방문자 점수(1점짜리)
        for(String visitor : visitors){
            int i= memberList.indexOf(visitor);

            if(i==-1) {    // 친구관계에서 나타나지 않았던 뉴페이스 방문자
                memberList.add(visitor);
                result.add(1);
            }
            else if(i>= matrix[0].length) { // 뉴페이스 방문자의 n번째 방문
                int target=result.get(i);
                result.set(i,++target);
            }
            else if(matrix[i][user_idx]!=1){ // 올드페이스들의 방문
                int target=result.get(i);
                result.set(i,++target);
            }
        }
        return result;
    }
    public static List<String> selectSuggestion(List<Integer> point, List<String> memList){

        List<String> suggestion=new ArrayList<>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        int cnt=0;

        // 이름, 점수로 구성된 맵 생성
        for(int i=0; i<memList.size();i++){
            if(point.get(i)==0) continue;
            map.put(memList.get(i),point.get(i));
        }

        // 점수 및 이름 알파벳순서에 따른 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });

        // 최종 5인 선발
        for(Map.Entry<String, Integer> entry : entryList){
            if(cnt==5 || entry.getValue()==0) break;
            suggestion.add(entry.getKey());
            cnt++;
        }
        return suggestion;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashSet<String> memberSet= new HashSet<String>();

        memberSet= collectWholeMember(friends); // 제공된 모든 멤버로 이루어진 셋 형성(중복제외 목적)
        List<String> memberList=new ArrayList<>(memberSet);

        int[][] adjMatrix= new int[memberSet.size()][memberSet.size()];
        adjMatrix=relationshipGraph(memberList,friends); //멤버들 간의 친구관계를 인접행렬(그래프 자료구조)로 구현

        List<Integer> point=calcPoint(adjMatrix,visitors,memberList,user); // 각 멤버들의 점수 계산
        answer=selectSuggestion(point,memberList); // 점수 높은 순 최대 5명 리턴 & 0은 제외

        return answer;
    }

}
