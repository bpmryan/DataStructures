import java.util.Arrays;

public class Minimax {

  public static void main(String[] args) {
    Minimax test = new Minimax(3);
  }

  public Vertex root;
  public String message;

  public Minimax(int size) {
    this.message = "Tic Tac Toe";
    this.root = new Vertex(size);
    growTree(this.root, 1, 0);
  }

  private int growTree(Vertex root, int turn, int utility) {
    // implement me
    for (int i = 0; i < root.board.length; i++) {
      root.grow(i, turn);
      // System.out.println(root.children.get(i));
    }
    for (Vertex child: root.children){
      growTree(child, -turn, utility);
    }
    return 0;
  }

  public void play(int place) {
    // implement me
  }

  public int gameOverState() {
    if (this.root.children.size() > 0)
      return Vertex.CONT;
    return this.root.terminal();
  }

  private String evalMessage() {
    if (this.root.children.size() > 0)
      return this.message;
    else if (this.root.terminal() == 0)
      return "Draw! (right click to reset).";
    else
      return "Peasant! (right click to reset).";
  }
}