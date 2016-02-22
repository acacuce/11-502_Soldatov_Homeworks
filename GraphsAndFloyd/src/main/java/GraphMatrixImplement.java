import exeptions.NoSuchPeak;

/**
 * Created by acacuce on 22.02.16.
 */
public class GraphMatrixImplement implements Graph,DirectedGraph {

    public static final int DEFAULT_SIZE = 100;
    private int peaksNumber = 0;
    private int[][] matrix;
    private int maxSize;

    public GraphMatrixImplement() {
        initMatrix(DEFAULT_SIZE);
    }

    public GraphMatrixImplement(int maxSize) {
        initMatrix(maxSize);
    }

    private void initMatrix(int maxSize) {
        this.maxSize = maxSize;
        this.matrix = new int[maxSize][maxSize];
    }

    public void addWeightedEdge(int a, int b, int size) {
        if ((a <= this.peaksNumber) || (b <= this.peaksNumber)) {
            this.matrix[a - 1][b - 1] = size;
        }
        else throw new NoSuchPeak();
    }

    public void addPeak() {
        this.peaksNumber ++;
    }

    public void addEdge(int a, int b) {
        if (a < peaksNumber && b < peaksNumber) {
            this.matrix[a][b] = 1;
            this.matrix[b][a] = 1;
        } else throw new NoSuchPeak();
    }

    public void showMatrix() {
        int n = this.peaksNumber;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] runFloyd() {
        FloydGenerator generator = new FloydGenerator(matrix, maxSize);
        this.matrix = generator.generate();
        return matrix;
    }
    public void addInfinity() {
        for(int i = 0; i < maxSize; i++) {
            for(int j = 0; j < maxSize; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][j] = 100;
                }
            }
        }
    }
    public void addZeros() {
        for(int i = 0; i < maxSize; i++) {
            matrix[i][i] = 0;
        }
    }
}
