package club.nullbyte3.flyweight.birch_trees;

public class Main {
    public static void main(String[] args) {
        int rows = 6;
        int cols = 16;
        TreeController controller = new TreeController(rows, cols);
        TreeView view = new TreeView(controller);
        System.out.println("Initial forest:");
        view.drawTrees();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                controller.makeTreeLeafy(r, c);
                System.out.println("Updated forest:");
                view.drawTrees();
            }
        }
    }
}
