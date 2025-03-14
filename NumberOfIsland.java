public class NumberOfIsland {

    static int numberofIsland(int[][] grid)
    {
       int count = 0;
       int row = grid.length;
       int col = grid[0].length;

       for(int i=0;i<row;i++)
       {
           for(int j=0;j<col;j++)
           {
               if(grid[i][j] == 1)
                   count += 1;
               islands(i,j,grid);
           }
       }
       return count;
    }

    static void islands(int row,int col,int[][] grid)
    {
        if(row < 0 || row >= grid.length || col < 0 || col>=grid[row].length || grid[row][col] == 0  )
        {
            return ;
        }

        grid[row][col] = 0 ;
        islands(row + 1, col, grid);
        islands(row - 1, col, grid);
        islands(row , col + 1, grid);
        islands(row , col - 1, grid);

    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 1}
        };

       int ans = numberofIsland(M);
       System.out.println(ans);
    }
}
