package ru.itis.inform;
import java.math.*;


public class FloydGenerator {
  private Matrix matrix;
  private int length;

  private final Matrix DEFAULT_MATRIX = new Matrix(10);

  public FloydGenerator() {
    initFloyd(DEFAULT_MATRIX);
  }

  public FloydGenerator(Matrix matrix) {
    initFloyd(matrix);
  }

  private void initFloyd(Matrix matrix) {
    this.length = matrix.getSize();
    this.matrix = matrix;
  }

  public void generate() {
    for(int i = 0; i < length; i++) {
      for(int j = 0; j < length; j++) {
	for(int k = 0; k < length; k++) {
	  int first = matrix.getAt(j, k);
	  int second = matrix.getAt(j, i) + matrix.getAt(i, k);
	  int min = Math.min(first, second);
	  matrix.setAt(j, k, min);
	}
      }
    }
  }
}
