package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class prob7 {

   public static String id(String id) {

      if(id.length()>30) { //���ڿ� 30�̻��ϰ��
         
         System.out.println("�Է°����� ���ڸ� �ʰ��Ͽ����ϴ�.");
         return null;
        }else {
           return id.toLowerCase();
        }
           
   }
   
   //ģ���� �迭 ����
      public String[][] friends = {{"donut","andole"},{"donut","jun"},
      {"donut", "mrko"}, {"shakevan", "andole"}, 
      {"shakevan", "jun"}, {"shakevan", "mrko"}};
   
   public String[] rel(String sid){ //ģ��ã��
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
    
    //�迭 �߰��ϴ� �޼ҵ�
    private static String[] Add(String[] originArray, String Val) {
    // ���� 1. (���� �迭�� ũ�� + 1)�� ũ�⸦ ������ �迭�� ����
    String[] newArray = new String[originArray.length + 1];
    
       // ���� 2. ���ο� �迭�� ���� ���������� �Ҵ�
       for(int index = 0; index < originArray.length; index++) {
         newArray[index] = originArray[index];
       }
       
       // ���� 3. ���ο� �迭�� ������ ��ġ�� �߰��Ϸ��� ���� �Ҵ�
       newArray[originArray.length] = Val;
       
       // ���� 4. ���ο� �迭�� ��ȯ
       return newArray;
    }

    public static void main(String[] args) {
       // TODO Auto-generated method stub
       
       HashMap<String,Integer> frjum = new HashMap<>();
       Scanner sc = new Scanner(System.in);//�Է½�ĳ��
       prob7 ex = new prob7();
       
       int jum[] = {0,0,0,0,0,0,0,0,0,0};
   
       System.out.println("ID�� �Է��ϼ���(�ҹ��ڸ� ����)");
       String sid = sc.nextLine();
       
      for(int i=0; i<ex.rel(sid).length; i++) {
         //System.out.println(ex.rel(sid)[i] +" :userģ��");
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
           if(!frjum.containsKey(el)) { //Ű���� ������� 1��
              frjum.put(el,1);
          }else if(frjum.containsKey(el)) { //Ű���� ������� ���ϱ�
               if (vist.indexOf(el) != vist.lastIndexOf(el)) { //�ߺ��� ���ֱ�
                  l+=1;
                  frjum.put(el,frjum.get(el)+l);
               }else {//�ߺ����� �ƴ� ��
                  frjum.put(el,frjum.get(el)+1);  
               }
          }
       }
       
        // value ������������ �����ϰ�, value�� ������ key ������������ ����
        List<Map.Entry<String, Integer>> tlist = new LinkedList<>(frjum.entrySet());
        Collections.sort(tlist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        // ���������� ���� LinkedHashMap�� ���
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        
        for(Iterator<Map.Entry<String, Integer>> iter = tlist.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey());
        }        

        //System.out.println(sortedMap.get(sortedMap));
        
        
      }

 }