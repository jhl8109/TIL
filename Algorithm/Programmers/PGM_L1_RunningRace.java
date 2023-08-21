import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i+1);
        }
        for(String calling: callings) {
            int rank = map.get(calling);
            String tmp = players[rank-2]; //rank-2 : 앞 등수 rank-1 : 기존 등수
            players[rank-2] = players[rank-1];
            players[rank-1] = tmp;
            map.put(players[rank-1], rank);
            map.put(players[rank-2], rank-1);
        }

        return players;
    }
}