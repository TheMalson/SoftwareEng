package exercise5;

/**
 * This is a simple binary tree implementation.
 * Each Node contains a value and two child nodes.
 */
public class Node {
    /**
     * The value of this node.
     */
    private final int value;

    /**
     * The left child node, for values smaller than this nodes value.
     */
    private Node left;

    /**
     * The right child node, for values greater than this nodes value.
     */
    private Node right;


    /**
     * Instantiates a new Node with a value.
     * Both child nodes are initially null.
     *
     * @param value the value for this node.
     */
    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    /**
     * Inserts a new node with the given value into the tree.
     * Smaller value are added to the left {@link Node}, greater values are added to the right {@link Node}.
     * No duplicates are stored.
     *
     * @param insertValue value to be added.
     */
    public void insert(int insertValue) {


        //Check whether new node has to go left or right
        if(insertValue<value){
            if(left==null){
                left = new Node(insertValue);
            } else{
                left.insert(insertValue);
            }

        } else if(insertValue>value){
            if(right==null){
                right = new Node(insertValue);
            } else{
                right.insert(insertValue);
            }

        }
    }

    /**
     * Prints the contents of the tree in sorted order to the standard output.
     */
    public void print() {

        boolean printed = false;

        if(left!=null){
            left.print();
            System.out.println(value);
            printed = true;
        } else{
            System.out.println(value);
            printed = true;
        }

        if (right!=null){
            if(printed!=true){
                System.out.println(value);
            }
            right.print();
        }


    }

    /**
     * Finds the {@link Node} containing the given value.
     * If no node with that value exists it returns null.
     *
     * @param searchValue value of node
     * @return the node containing the given value
     */
    public Node find(int searchValue) {

        Node resultNode = null;

        //Check if searchValue is the value of the current Node
        if(searchValue==value){
            resultNode = this;
        }

        //Check if searchValue is in the left or right subtree
        if(searchValue<value){
            resultNode = left.find(searchValue);
        }

        if(searchValue>value){
            resultNode = right.find(searchValue);
        }

        return resultNode;
    }
}