class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> curSet;
        for(int i=0;i<9;i++) {
            curSet = new HashSet<>();
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    if(!curSet.contains(board[i][j])) {
                        curSet.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        for(int i=0;i<9;i++) {
            curSet = new HashSet<>();
            for(int j=0;j<9;j++) {
                if(board[j][i]!='.') {
                    if(!curSet.contains(board[j][i])) {
                        curSet.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }

        int x=0,y=0;
        for(int i=0;i<9;i++) {
            curSet = new HashSet<>();
            for(int j=0;j<9;j++) {
                x = ((i/3))*3 + j/3;
                y = ((i%3))*3 +j%3;
                if(board[x][y]!='.') {
                    if(!curSet.contains(board[x][y])) {
                        curSet.add(board[x][y]);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
