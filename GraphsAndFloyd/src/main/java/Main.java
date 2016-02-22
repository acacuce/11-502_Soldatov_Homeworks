public class Main {

  public static void main(String[] args) {
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
    graph.showMatrix();
    System.out.println();
    graph.runFloyd();
    graph.showMatrix();
  }
  }
