package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> makeUserListByRecommendation(){
        List<String> result = Collections.emptyList();
        return result;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        SocialGraph sg = new SocialGraph(friends);
        return answer;
    }

    private static class SocialGraph {
        private List<Entry> orderedList;
        private boolean[][] isConnected;
        private EntryComparator cmp;
        public SocialGraph(List<List<String>> friends) {

            for(int i = 0; i < friends.size(); i++) {
                String usernameA = friends.get(i).get(0);
                String usernameB = friends.get(i).get(1);

                Entry userA = new Entry(usernameA,0);
                Entry userB = new Entry(usernameB,0);

                if (!orderedList.contains(userA)) orderedList.add(userA);
                if (!orderedList.contains(userB)) orderedList.add(userB);
            }

            Collections.sort(orderedList);

            for(int i = 0; i < friends.size(); i++){
                String usernameA = friends.get(i).get(0);
                String usernameB = friends.get(i).get(1);

                Entry userA = new Entry(usernameA,0);
                Entry userB = new Entry(usernameB,0);

                int a = orderedList.indexOf(userA);
                 int b = orderedList.indexOf(userB);

                 isConnected[a][b] = true;
                 isConnected[b][a] = true;
            }
        }
        private int findIndex(String username){
            Entry userEntry = new Entry(username,0);
            return orderedList.indexOf(userEntry);
        }
        public boolean areFriend(String usernameA, String usernameB){
            int indexA = findIndex(usernameA), indexB = findIndex(usernameB);
            return isConnected[indexA][indexB];
        }
        public List<Entry> friendList(String a){
            return Collections.emptyList();
        }

        public int userLength(){
            return orderedList.size();
        }
        public List<Entry> users(){
            return List.copyOf(orderedList);
        }
    }

    private static class Entry implements Comparable<Entry>  {
        protected String name = "";
        protected int recommendationValue = 0;

        protected Entry(String sname, int value){
            this.name = sname;
            this.recommendationValue = value;
        }

        @Override
        public int compareTo(Entry o) {
            int tmp = this.name.compareTo( o.name);
            if( tmp > 0){
                return -1;
            }else if (tmp < 0){
                return 1;
            }
            return 0;
        }
        public boolean equals(Entry o){
            return this.name.equals(o.name);
        }
    }
    private static class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return (o1.recommendationValue - o2.recommendationValue);
        }
    }
}
