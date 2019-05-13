package Nodes;

import java.io.Serializable;

public class DoubleNodeSearch<T extends Comparable>{

  T data;
  Nodes.DoubleNodeSearch<T> left;
  Nodes.DoubleNodeSearch<T> right;

  public DoubleNodeSearch(T data) {
      this.data = data;
  }
  public DoubleNodeSearch(T data, DoubleNodeSearch<T> left, DoubleNodeSearch<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
  }

  public DoubleNodeSearch() {}

  public T getData() {
      return data;
  }

  public void setData(T data) {
      this.data = data;
  }

  public DoubleNodeSearch<T> getLeft() {
      return left;
  }

  public void setLeft(DoubleNodeSearch<T> left) {
      this.left = left;
  }

  public DoubleNodeSearch<T> getRight() {
      return right;
  }

  public void setRight(DoubleNodeSearch<T> right) {
            this.right = right;
        }
}
