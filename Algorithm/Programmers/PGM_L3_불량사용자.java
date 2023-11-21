import java.util.*;

public class Solution {
    Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, banned_id, visited, 0);
        return resultSet.size();
    }

    private void dfs(String[] user_id, String[] banned_id, boolean[] visited, int depth) {
        if (depth == banned_id.length) {
            Set<String> result = new HashSet<>();
            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) result.add(user_id[i]);
            }
            resultSet.add(result);
            return;
        }

        String pattern = banned_id[depth].replace("*", ".");
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(pattern)) {
                visited[i] = true;
                dfs(user_id, banned_id, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}