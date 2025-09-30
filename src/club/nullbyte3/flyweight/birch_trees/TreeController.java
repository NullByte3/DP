package club.nullbyte3.flyweight.birch_trees;

public class TreeController {
    private final Tree[][] trees;
    private final TreeImageFactory treeImageFactory;

    public TreeController(int rows, int cols) {
        this.treeImageFactory = new TreeImageFactory();
        this.trees = new Tree[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                trees[r][c] = new Tree(r, c, treeImageFactory.getTreeImage(TreeImageFactory.LEAFLESS));
            }
        }
    }

    public void makeTreeLeafy(int row, int col) {
        trees[row][col].setTreeImage(treeImageFactory.getTreeImage(TreeImageFactory.LEAFY));
    }

    public boolean isTreeLeafy(int row, int col) {
        return trees[row][col].getTreeImage() == treeImageFactory.getTreeImage(TreeImageFactory.LEAFY);
    }

    public int getRows() {
        return trees.length;
    }

    public int getCols() {
        return trees[0].length;
    }

    public Tree getTree(int row, int col) {
        return trees[row][col];
    }
}
