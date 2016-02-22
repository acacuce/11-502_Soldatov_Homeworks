public interface DirectedGraph {
  void addPeak();
  void addWeightedEdge(int a, int b, int size);
  void showMatrix();
  int [] [] runFloyd();
}
