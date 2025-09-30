package club.nullbyte3.flyweight.birch_trees;

public class TreeView {
    private final TreeController treeController;

    public TreeView(TreeController treeController) {
        this.treeController = treeController;
    }

    public void drawTrees() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < treeController.getRows(); r++) {
            for (int c = 0; c < treeController.getCols(); c++) {
                sb.append(treeController.getTree(r, c).getSymbol());
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
