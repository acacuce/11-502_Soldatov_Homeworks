package ru.itis.inform;

public class Matrix implements Graph {
  public static final int DEFAULT_SIZE = 100;

  private int peaksNumber = 0;
  private int[][] matrix;

  private int maxSize; 

  public void addPeak() {
    this.peaksNumber++;
  }

  public Matrix() {
    initMatrix(DEFAULT_SIZE);
  }

  public Matrix(int maxSize) {
    initMatrix(maxSize);
  }

  private void initMatrix(int maxSize) {
    this.maxSize = maxSize;
    this.matrix = new int[maxSize][maxSize];
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

  public int getSize() {
    return this.maxSize;
  }

  public void setAt(int i, int j, int value) {
    matrix[i][j] = value;
  }

  public int getAt(int i, int j) {
    return matrix[i][j];
  }

  public void addEdge(int a, int b, int size) {
    if ((a <= this.peaksNumber) || (b <= this.peaksNumber)) {
      this.matrix[a - 1][b - 1] = size;
    }
    else throw new NoSuchPeak();
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
}
