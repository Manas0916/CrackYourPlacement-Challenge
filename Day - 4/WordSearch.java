class Solution 
{
    int m, n;
    boolean vis[][];
    int dir[][] = {{0, 1},{-1, 0}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) 
    {
        m = board.length; n = board[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] != word.charAt(0)) continue;
                
                if(solve(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    boolean solve(char[][] grid, int i, int j, int id, String s)
    {
        if(id == s.length()) return true;
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        
        if(grid[i][j] != s.charAt(id)) return false;
        
        char ch = grid[i][j];
        grid[i][j] = '#';
        for(int d[]: dir)
        {
            int ni = i + d[0];
            int nj = j + d[1];
            if(solve(grid, ni, nj, id + 1, s))
            {
                grid[i][j] = ch;
                return true;
            }
        }
        grid[i][j] = ch;
        return false;
    }
}