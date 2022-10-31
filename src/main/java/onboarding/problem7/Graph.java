package onboarding.problem7;

import onboarding.Problem7;

import java.util.*;

public class Graph
{
    private Map<String,Vertex> userNameToVertex = new HashMap<>();
    private Map<Integer,Vertex> indexToVertex = new HashMap<>();
    private Set<Integer>[] friendGraph;
    private int nextUserIndex = 0;
    private static class Vertex implements Comparable<Vertex>
    {
        private static final int InitScoreValue = 0;

        private String name;
        private Integer index;
        private int score;

        public Vertex(String name,int nextUserIndex)
        {
            this.name = name;
            this.index = nextUserIndex;
            score = InitScoreValue;
        }

        @Override
        public int compareTo(Vertex o) {

            if(score != o.score)
            {
                return o.score - score;
            }

            return name.compareTo(o.name);
        }

        @Override
        public String toString()
        {
            return "name: " + name +", score: " + score + ", index: " + index;
        }
    }

    private Vertex makeVertex(String name)
    {
        return new Vertex(name,nextUserIndex++);
    }
    public Graph(int size)
    {
        friendGraph = new TreeSet[size];
        for(int i = 0 ; i < friendGraph.length;i++)
        {
            friendGraph[i] = new TreeSet<Integer>();
        }
    }

    public Vertex enrollUserAndReturnVertex(String userName)
    {
        Vertex vertex;
        if(userNameToVertex.containsKey(userName))
        {
            vertex = userNameToVertex.get(userName);
        }
        else
        {
            vertex = makeVertex(userName);
            userNameToVertex.put(userName,vertex);
            indexToVertex.put(vertex.index,vertex);
        }

        return vertex;
    }

    public void connect(String userName,String friendName)
    {
        Vertex userVertex = enrollUserAndReturnVertex(userName);
        Vertex friendVertex = enrollUserAndReturnVertex(friendName);
        friendGraph[userVertex.index].add(friendVertex.index);
        friendGraph[friendVertex.index].add(userVertex.index);
    }

    private void updateScoreWithVisitors(List<String> visitors)
    {
        for(int i = 0 ; i < visitors.size();i++)
        {
            Vertex visitorVertex = enrollUserAndReturnVertex(visitors.get(i));
            visitorVertex.score += Problem7.VISITOR_SCORE;
        }
    }

    private boolean isEqual(Vertex userVertex,Vertex anotherUserVertex)
    {
        return userVertex.index == anotherUserVertex.index;
    }

    private boolean isFriend(Vertex userVertex,Vertex anotherUserVertex)
    {
        return friendGraph[userVertex.index].contains(anotherUserVertex.index);
    }
    private void calculateScore(Vertex vertex,Vertex userVertex)
    {
        Set<Integer> userFriends = friendGraph[userVertex.index];
        for (Integer userFriendIndex: userFriends)
        {
            Vertex userFriendVertex = indexToVertex.get(userFriendIndex);
            if(isFriend(userFriendVertex,vertex))
            {
                vertex.score+=Problem7.FRIEND_SCORE;
            }
        }
    }

    private void updateScoreWithFriend(String userName)
    {
        Vertex userVertex = enrollUserAndReturnVertex(userName);

        for(int i = 0 ; i < nextUserIndex;i++)
        {
            Vertex vertex = indexToVertex.get(i);
            if(!isFriend(vertex,userVertex) && !isEqual(vertex ,userVertex))
            {
                calculateScore(vertex,userVertex);
            }
        }
    }
    private PriorityQueue<Vertex> getRecommendFriend(String userName)
    {
        Vertex userVertex = enrollUserAndReturnVertex(userName);

        PriorityQueue<Vertex> recommendFriendStorage = new PriorityQueue<>();
        for(int i = 0 ; i < nextUserIndex;i++)
        {
            Vertex vertex = indexToVertex.get(i);
            if(!isFriend(vertex,userVertex))
            {
                recommendFriendStorage.add(vertex);
            }
        }

        return recommendFriendStorage;
    }
    public void updateScore(String userName,List<String> visitors)
    {
        updateScoreWithVisitors(visitors);
        updateScoreWithFriend(userName);
    }

    public List<String> getResult(String userName)
    {
        PriorityQueue<Vertex> recommendFriendStorage = getRecommendFriend(userName);

        List<String> result = new LinkedList<>();
        int i = 0;
        while(!recommendFriendStorage.isEmpty() && i < Problem7.MAX_RETURN_SIZE)
        {
            Vertex vertex =recommendFriendStorage.remove();
            if(vertex.score != Problem7.EXCEPTION_SCORE)
            {
                result.add(vertex.name);
                i++;
            }
        }

        return result;
    }


}