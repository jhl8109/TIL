class Solution {
    public static int n,m;
    public int matrixScore(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for(int i=0; i<n; i++) {
            if(grid[i][0] == 0) grid = horizontal(i, grid);
        }
        for(int i=0; i<m; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(grid[j][i] == 0) count++;
            }
            if(count > n/2) grid = vertical(i,grid);
        }
        int answer = 0;
        for(int i=0; i<n; i++) {
            int tmp = 0;
            for(int j=0; j<m; j++) {
                tmp *= 2;
                tmp += grid[i][j];
            }
            answer += tmp;
        }
        return answer;
    }
    public int[][] horizontal(int height, int[][] grid) {
        for(int i=0; i<m; i++) {
            if(grid[height][i] == 0) grid[height][i] = 1;
            else grid[height][i] = 0;
        }
        return grid;
    }
    public int[][] vertical(int point, int[][] grid) {
        for(int i=0; i<n; i++) {
            if(grid[i][point] == 0) grid[i][point] = 1;
            else grid[i][point] = 0;
        }
        return grid;
    }
    
}