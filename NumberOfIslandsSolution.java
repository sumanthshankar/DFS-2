// Time Complexity : O(m X n)
// Space Complexity : O(m X n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        //Base case check
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //Queue data structure for BFS traversal
        Queue<int[]> q = new LinkedList<>();
        //Traverse the grid and search for 1, if you find it's an island.
        //Start BFS in all 4 directions
        for(int row = 0; row < rows; row += 1) {
            for(int col = 0; col < cols; col += 1) {
                if(grid[row][col] == '1') {
                    count += 1;
                    q.add(new int[] {row, col});
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] direction : directions) {
                            int newRow = curr[0] + direction[0];
                            int newCol = curr[1] + direction[1];
                            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0';
                                q.add(new int[] {newRow, newCol});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
