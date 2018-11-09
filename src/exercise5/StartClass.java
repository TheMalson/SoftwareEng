package exercise5;

public class StartClass {

    public static void main(String[] args) {

        // create root node and insert values.
        Node root = new Node(1);
        root.insert(7);
        root.insert(3);
        root.insert(4);
        root.insert(2);
        root.insert(6);
        root.insert(5);

        // print values of tree.
        // if it works correctly, it will print numbers 1 to 7.
        System.out.println("print tree:");
        root.print();

        // find node with certain value und print it.
        System.out.println("print sub-tree from node containing '6'");
        final Node node = root.find(6);
        node.print();
    }
}

