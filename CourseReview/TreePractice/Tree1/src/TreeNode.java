public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }



    /**min and max**/
    public int min(){
        if (this.leftChild != null){
            return leftChild.min();
        }
        return this.data;
    }

    public int max(){
        if (this.rightChild != null){
            return this.rightChild.max();
        }
        return this.data;
    }

    /**getters**/
    public TreeNode get(int value){
        if (this.data == value){
           return this;
        }

        if (this.data < value){
            if (this.leftChild != null){
                return this.leftChild.get(value);
            }
        }

        if (this.data > value){
            if (this.rightChild != null){
                return this.rightChild.get(value);
            }
        }
        return null;
    }

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
