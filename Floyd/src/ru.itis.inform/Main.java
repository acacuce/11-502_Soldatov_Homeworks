package ru.itis.inform;
public class Main {

  public static void main(String[] args) {
    Matrix graph = new Matrix(4);

    for(int i = 0; i < 4; i++) {
      graph.addPeak();
    }

    graph.addEdge(1, 2, 1);
    graph.addEdge(1, 3, 6);
    graph.addEdge(2, 3, 4);
    graph.addEdge(2, 4, 1);
    graph.addEdge(2, 4, 1);
    graph.addEdge(2, 1, 100);
    graph.addEdge(3, 1, 100);
    graph.addEdge(3, 2, 100);
    graph.addEdge(4, 1, 100);
    graph.addEdge(4, 2, 100);
    graph.addEdge(4, 3, 1);



    graph.addInfinity();
    graph.addZeros();

    graph.showMatrix();
    System.out.println();

    FloydGenerator generator = new FloydGenerator(graph);
    generator.generate();
    graph.showMatrix();
  }
}
