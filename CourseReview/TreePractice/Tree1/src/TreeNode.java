public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    /**getters**/
    public int getData(){
        return this.data;
    }

    public TreeNode getLeftChild(){
        return this.leftChild;
    }

    public TreeNode getRightChild(){
        return this.rightChild;
    }

    /**setters**/
    public void setData(int newData){
        this.data = newData;
    }

    public void setLeftChild(TreeNode newLeftChild){
        this.leftChild = newLeftChild;
    }

    public void setRightChild(TreeNode newRightChild){
        this.rightChild = newRightChild;
    }
}
