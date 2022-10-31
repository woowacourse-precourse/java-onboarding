package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        SocialGraph sg = new SocialGraph(friends, visitors);
        List<Entry> users = new ArrayList<>(sg.users());
        int indexUser = sg.findIndex(user);

        for(int i =0; i <users.size(); i++){
            if ( i == indexUser) continue;
            Entry userEntryA = users.get(i);
            if (!sg.areFriend(user, userEntryA.name)){
                userEntryA.recommendationValue += 10 * sg.numberCommonFriends(user, userEntryA.name);
            }
        }

        for(String userVisitorName : visitors){
            int indexUserVisitor = sg.findIndex(userVisitorName);
            Entry userEntryVisitor = users.get(indexUserVisitor);

            if(!sg.areFriend(user, userVisitorName)){
                userEntryVisitor.recommendationValue += 1;

            }
        }

        Collections.sort(users);

        for(int i =0; i < Math.max(sg.userLength(),5); i++ ){
            if (users.get(i).recommendationValue > 0){
                answer.add(users.get(i).name);
//                System.out.printf("%s(%d) ", users.get(i).name, users.get(i).recommendationValue);
            }
        }


        return answer;
    }

    private static class SocialGraph {
        private List<Entry> orderedList = new ArrayList<>();
        private boolean[][] isConnected;

        private void _initializeOrderedList (List<List<String>> friends, List<String> visitors){
            for(int i = 0; i < friends.size(); i++) {
                String usernameA = friends.get(i).get(0);
                String usernameB = friends.get(i).get(1);

                Entry userA = new Entry(usernameA,0);
                Entry userB = new Entry(usernameB,0);

                if (!orderedList.contains(userA)) orderedList.add(userA);
                if (!orderedList.contains(userB)) orderedList.add(userB);

            }

            for( String username : visitors){
                Entry userEntry = new Entry(username,0);
                if(!orderedList.contains(userEntry)) orderedList.add(userEntry);
            }
            Collections.sort(orderedList);

        }
        private void _makeConnectionMap (List<List<String>> friends){
            int n = orderedList.size();
            isConnected = new boolean[n][n];

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

        public SocialGraph(List<List<String>> friends, List<String> visitors) {
            _initializeOrderedList(friends,visitors);
            _makeConnectionMap(friends);
        }

        private int findIndex(String username){
            Entry userEntry = new Entry(username,0);
            return orderedList.indexOf(userEntry);
        }
        public boolean areFriend(String usernameA, String usernameB){
            int indexA = findIndex(usernameA), indexB = findIndex(usernameB);
            return isConnected[indexA][indexB];
        }
        public List<Entry> friendList(String username){
            return Collections.emptyList();
        }

        public int numberCommonFriends(String usernameA, String usernameB){
            int indexA = findIndex(usernameA), indexB = findIndex(usernameB);
            int result = 0;
            for (int i =0; i< userLength(); i++){
                if( i != indexA && i != indexB && isConnected[i][indexA] && isConnected[i][indexB]){
                    result++;
                }
            }

            return result;
        }


        public int userLength(){
            return orderedList.size();
        }
        public List<Entry> users(){
            return List.copyOf(orderedList);
        }
    }

    private static class Entry implements Comparable<Entry>  {
        public String name = "";
        public int recommendationValue = 0;

        protected Entry(String sname, int value){
            this.name = sname;
            this.recommendationValue = value;
        }

        @Override
        public int compareTo(Entry o) {
            int  difference = this.recommendationValue - o.recommendationValue;
            if( difference < 0 ){
                return 1;
            }else if( difference > 0){
                return -1;
            }

            int tmp = this.name.compareTo(o.name);
            if( tmp > 0){
                return 1;
            }else if (tmp < 0){
                return -1;
            }
            return 0;
        }
        @Override
        public boolean equals(Object o){
            if (o == null || getClass() != o.getClass())
                return false;
            Entry other = (Entry) o;
            return this.name.equals(other.name);
        }

    }

}
