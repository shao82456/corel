package dp;

public class NumMatrix {
    //data[i][j]表示有[0][0]到[i][j]所有数字的和
    //data[i][j]=data[i-1][j]+sum[(i,0),(i,j)]
    int[][] data;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {

        } else {

            data = new int[matrix.length][matrix[0].length];
            int curRow = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                curRow += matrix[0][i];
                data[0][i] = curRow;
            }
            for (int i = 1; i < matrix.length; i++) {
                curRow = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    curRow += matrix[i][j];
                    data[i][j] = curRow + data[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(data==null){
            return 0;
        }
        int s1 = data[row2][col2];
        int s4 = 0;
        int s2 = 0;
        int s3 = 0;

        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            s4 = data[row1 - 1][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            s2 = data[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            s3 = data[row2][col1 - 1];
        }
        return s1 - s2 - s3 + s4;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(1, 1, 2, 2);
        System.out.println(param_1);
    }
}
