public class Tree {

    private TreeNode root;

    public Tree(){
    }

    public void insert(int data){
        if (this.root == null ){
            this.root = new TreeNode(data);
        } else {
            this.root.insert(data);
        }
    }

    public void traverseInorder(){
        if (root != null){
            root.traverseInorder();
        }
    }

    public void traversePreorder(){
        if (root != null){
            root.traversePreorder();
        }
    }

    public TreeNode get(int value) {
        if (this.root != null) {
            return this.root.get(value);
        } else {
            return null;
        }
    }

    public int min(){
        if (root != null){
            return root.min();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int max(){
        if (root != null){
            return root.max();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void delete(int data){
        root = delete(root, data);
    }

    private TreeNode delete(TreeNode subtreeRoot, int data){
        if (subtreeRoot == null){
            return subtreeRoot;
        }

        if (data < subtreeRoot.getData()){ //data is less than current root
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), data));
        } else if (data > subtreeRoot.getData()) { //data is greater than current root
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),data));
        } else { // data is equal to the root, so we delete this. Cases: node to delete has 0 or 1 child
            if (subtreeRoot.getLeftChild() == null){
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            /** Case: node has 2 children*/
            /*replace data in subtreeRoot with min value from the right subtree*/
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            /*delete the node that has the smallest value in the right subtree*/
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }
}
