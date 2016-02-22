import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by acacuce on 22.02.16.
 */
public class GraphMatrixImplementTest extends junit.framework.TestCase {
    private int [][] floydMatrix;
    @org.junit.Before
    public void setUp() throws Exception {
        floydMatrix = new int[4][4];
        for (int i = 0; i < floydMatrix.length; i++){
            for (int j = 0; j < floydMatrix.length; j++){
                if (i == j) {
                    floydMatrix[i][i] = 0;
                }
            }
        }
        floydMatrix [0][1] = 2;
        floydMatrix [0][2] = 3;
        floydMatrix [0][3] = 3;
        floydMatrix [1][0] = 3;
        floydMatrix [1][2] = 6;
        floydMatrix [1][3] = 1;
        floydMatrix [2][0] = 15;
        floydMatrix [2][1] = 12;
        floydMatrix [2][3] = 4;
        floydMatrix [3][0] = 11;
        floydMatrix [3][1] = 8;
        floydMatrix [3][2] = 14;


    }

    @org.junit.Test
    public void testRunFloyd() throws Exception {
        GraphMatrixImplement graph = new GraphMatrixImplement(4);
        for(int i = 0; i < 4; i++) {
            graph.addPeak();
        }
        graph.addInfinity();
        graph.addZeros();
        graph.addWeightedEdge(1, 2, 2);
        graph.addWeightedEdge(1, 3, 3);
        graph.addWeightedEdge(2, 1, 3);
        graph.addWeightedEdge(2, 4, 1);
        graph.addWeightedEdge(3, 4, 4);
        graph.addWeightedEdge(4, 2, 8);
        int expectedMatrix [][] = graph.runFloyd();

        for (int i = 0; i < floydMatrix.length; i++){
            for (int j = 0; j < floydMatrix.length; j++){
                assertEquals(floydMatrix[i][j], expectedMatrix[i][j] );
            }
        }
    }
}