package onboarding;

import java.util.*;

public class Problem7{

    public static String id(String id) {

        if(id.length()>30) { //문자열 30이상일경우

            System.out.println("입력가능한 글자를 초과하였습니다.");
            return null;
        }else {
            return id.toLowerCase();
        }

    }

    //친구들 배열 선언
    public String[][] friends = {{"donut","andole"},{"donut","jun"},
            {"donut", "mrko"}, {"shakevan", "andole"},
            {"shakevan", "jun"}, {"shakevan", "mrko"}};

    public String[] rel(String sid){ //친구찾기
        String fr[] = {};
        for(int i = 0; i < friends.length; i++) {
            for(int j=0;j < 2; j++) {
                if(sid.equals(friends[i][j])) {
                    if(friends[i][0].equals(sid)){
                        //System.out.println(friends[i][1] + ": " + i + ":" + j + " : 8");
                        fr = Add(fr, friends[i][1]);
                    }
                    if(friends[i][1].equals(sid))
                    {
                        //System.out.println(friends[i][0] + ": " + i + ":" + j + " : 9");
                        fr = Add(fr, friends[i][0]);
                    }
                }
            }
        }
        return fr;
    }

    public String[] frrel(String sid, String user){
        String frfr[] = {};
        for(int i = 0; i < friends.length; i++) {
            for(int j=0;j < 2; j++) {
                //System.out.println(friends[i][j] + " : 6");
                if(sid.equals(friends[i][j])) {
                    if(friends[i][0].equals(sid) && !friends[i][1].equals(user))
                    {
                        //System.out.println(friends[i][1] + ": " + i + ":" + j + " : 8");
                        frfr = Add(frfr, friends[i][1]);
                    }
                    if(friends[i][1].equals(sid) && !friends[i][0].equals(user))
                    {
                        //System.out.println(friends[i][0] + ": " + i + ":" + j + " : 9");
                        frfr = Add(frfr, friends[i][0]);
                    }
                }
            }
        }
        return frfr;
    }

    //배열 추가하는 메소드
    private static String[] Add(String[] originArray, String Val) {
        // 순서 1. (원본 배열의 크기 + 1)를 크기를 가지는 배열을 생성
        String[] newArray = new String[originArray.length + 1];

        // 순서 2. 새로운 배열에 값을 순차적으로 할당
        for(int index = 0; index < originArray.length; index++) {
            newArray[index] = originArray[index];
        }

        // 순서 3. 새로운 배열의 마지막 위치에 추가하려는 값을 할당
        newArray[originArray.length] = Val;

        // 순서 4. 새로운 배열을 반환
        return newArray;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<String,Integer> frjum = new HashMap<>();
        Scanner sc = new Scanner(System.in);//입력스캐너
        Problem7 ex = new Problem7();

        int jum[] = {0,0,0,0,0,0,0,0,0,0};

        System.out.println("ID를 입력하세요(소문자만 가능)");
        String sid = sc.nextLine();

        for(int i=0; i<ex.rel(sid).length; i++) {
            //System.out.println(ex.rel(sid)[i] +" :user친구");
            for(int j=0;j<ex.frrel(ex.rel(sid)[i],sid).length;j++){
                jum[j] +=10;
                //System.out.println(ex.frrel(ex.rel(sid)[i],sid)[j] + " : "+jum[j]);
                frjum.put(ex.frrel(ex.rel(sid)[i],sid)[j],jum[j]);
            }
        }
        //System.out.println(frjum);

        List<String> vist = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        for (String el : vist) {
            int l=0;
            if(!frjum.containsKey(el)) { //키값이 없을경우 1점
                frjum.put(el,1);
            }else if(frjum.containsKey(el)) { //키값이 있을경우 더하기
                if (vist.indexOf(el) != vist.lastIndexOf(el)) { //중복값 값넣기
                    l+=1;
                    frjum.put(el,frjum.get(el)+l);
                }else {//중복값이 아닐 때
                    frjum.put(el,frjum.get(el)+1);
                }
            }
        }

        // value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        List<Map.Entry<String, Integer>> tlist = new LinkedList<>(frjum.entrySet());
        Collections.sort(tlist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for(Iterator<Map.Entry<String, Integer>> iter = tlist.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey());
        }

        //System.out.println(sortedMap.get(sortedMap));


    }

}