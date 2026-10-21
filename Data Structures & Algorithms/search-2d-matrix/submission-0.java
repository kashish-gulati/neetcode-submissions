class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //serach row
        int row = searchRow(matrix,target,0,matrix.length);
        if(row==-1) return false;
        //search elem
        return searchInRow(matrix,target,0,matrix[0].length,row)!=-1;
    }

    public int searchRow(int[][] matrix, int target, int low, int high) {
        if(low>=high) return -1;
        int m = (low+high)/2;
        if(matrix[m][0]<=target && (m+1==matrix.length || matrix[m+1][0]>target)) return m;
        else if(matrix[m][0]>target) return searchRow(matrix,target,low,m);
        else return searchRow(matrix,target,m+1,high);
    }

    public int searchInRow(int[][] matrix, int target, int low, int high, int row) {
        if(low>=high) return -1;
        int m = (low+high)/2;
        if(matrix[row][m]==target) return m;
        else if(matrix[row][m]>target) return searchInRow(matrix,target,low,m,row);
        else return searchInRow(matrix,target,m+1,high,row);
    }
}
