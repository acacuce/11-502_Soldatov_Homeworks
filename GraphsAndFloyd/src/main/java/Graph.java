/**
 * Created by acacuce on 22.02.16.
 */
public interface Graph {
    void addPeak();
    void addEdge(int a, int b);
    void showMatrix();
    int [] [] runFloyd();

}
