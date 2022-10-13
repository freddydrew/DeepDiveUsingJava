public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    public void insert(int data){
        if (this.data == data){
            return; //our tree does not support duplicate values!
        }

        if (data < this.data){
            if (this.leftChild == null){
                leftChild = new TreeNode(data);
            } else {
                leftChild.insert(data);
            }
        }
        if (data > this.data){
            if (this.rightChild == null){
                rightChild = new TreeNode(data);
            } else {
                rightChild.insert(data);
            }
        }
    }

    public void traverseInorder(){
        if (leftChild != null){
            leftChild.traverseInorder();
        }
        System.out.print("Data = " + this.data + " | ");
        if (rightChild != null){
            rightChild.traverseInorder();
        }
    }

    public void traversePreorder(){
        System.out.print("Data = " + this.data + " | ");
        if (leftChild != null){
            leftChild.traverseInorder();
        }
        if (rightChild != null){
            rightChild.traverseInorder();
        }
    }

    public int min(){
        if (leftChild != null){
            return leftChild.min();
        }
        return this.data;
    }

    public int max(){
        if (rightChild != null){
            return rightChild.max();
        }
        return this.data;
    }

    public TreeNode get(int value){
        if (value == this.data){
            return this;
        }

        if (value < this.data){
            if (leftChild != null){
                return leftChild.get(value);
            }
        }

        if (value > this.data){
            if (rightChild != null){
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
