package leetCode;

public class _岛屿的个数 {
    public static void main(String[] args) {
        char arr[][] = {{'1','1','1','1','0'}
                        ,{'1','1','0','1','0'}
                        ,{'1','1','0','0','0'}
                        ,{'0','0','0','0','0'}};
        char arr2[][] = {"11110".toCharArray(),
                         "11010".toCharArray(),
                         "11000".toCharArray(),
                         "00000".toCharArray() };
        char arr3[][] = {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        };

        System.out.println(numIslands(arr3));
    }
    static int n,m;
    public static int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void dfs(int i,int j,char[][] grid){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0') return;
        grid[i][j] = '0';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}
