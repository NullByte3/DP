package club.nullbyte3.flyweight.birch_trees;

public class Tree {
    private final int row;
    private final int col;
    private TreeImage treeImage;

    public Tree(int row, int col, TreeImage treeImage) {
        this.row = row;
        this.col = col;
        this.treeImage = treeImage;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public TreeImage getTreeImage() {
        return treeImage;
    }

    public void setTreeImage(TreeImage treeImage) {
        this.treeImage = treeImage;
    }

    public char getSymbol() {
        String img = treeImage.getImage();
        if (img == null || img.isEmpty()) {
            return '?';
        }
        return img.charAt(0);
    }
}
