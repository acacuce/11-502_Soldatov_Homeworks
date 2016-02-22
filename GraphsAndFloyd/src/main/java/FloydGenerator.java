import java.math.*;


public class FloydGenerator {
    private int [][] matrix;
    private int length;

    public FloydGenerator(int[][] matrix, int maxSize) {
      this.length = maxSize;
      this.matrix = matrix;
    }

    public void setAt(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getAt(int i, int j) {
        return matrix[i][j];
    }

    public int[][] generate() {
    for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
            for(int k = 0; k < length; k++) {
	            int first = getAt(j, k);
                int second = getAt(j, i) + getAt(i, k);
                int min = Math.min(first, second);
                setAt(j, k, min);
            }
        }
    }
        return matrix;
  }
}
