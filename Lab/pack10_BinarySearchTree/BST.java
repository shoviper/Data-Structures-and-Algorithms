// Inthat Sappipat 65011304

import code.TreeNode;

public class BST {
    TreeNode root;

    public BST() { root = null; }

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args){
        demo1();
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                    /* your code 1*/
                    cur.left = new TreeNode(d);
                    cur.left.parent = cur;
                    return;
                    }
                } else { //! (d < p.data)
                    if (cur.right != null)
                        /* your code 2*/
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            } //while
        }
    } //insert by iteration

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }
    private void printPreOrderRecurse(TreeNode node) {
        /* your code 3*/
        if(node == null) 
            return;
        System.out.println(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }

    public static void demo1() {
        System.out.println("-insert and preOrder traversal-");
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };

        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);

        bst.printPreOrder();
        // 15 10 8 12 20 18 16 19 25 30
        System.out.println();
        demo2(bst);
    }

    //uncomment demo2() invocation inside demo1()
    public static void demo2(BST bst) {
        System.out.println("-more traversal---");
        bst.printInOrder();
        System.out.println();
        // 8 10 12 15 16 18 19 20 25 30
        bst.printPostOrder();
        System.out.println();
        // 8 12 10 16 19 18 30 25 20 15
        demo3(bst);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    private void printInOrderRecurse(TreeNode node) {
        /* your code 4*/
        if(node == null) 
            return;
        printInOrderRecurse(node.left);
        System.out.println(node.data + " ");
        printInOrderRecurse(node.right);
    }
        
    public void printPostOrder() {
        printPostOrderRecurse(root);
    }
        
    private void printPostOrderRecurse(TreeNode node) {
        /* your code 5*/
        if(node == null) 
            return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.println(node.data + " ");
    }

    public static void demo3(BST bst) {
        System.out.println("-search recursive---");
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null
        System.out.println(bst.search(1)); // null
        System.out.println(bst.searchRecurse(10, bst.getRoot()));
        //if searchRecurse and getRoot is available
        System.out.println("-search iterative---");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null) return null;
        if (d == n.data) return n;
        /* your code 7*/
        if(d < n.data)
            return searchRecurse(d, n.left);
        return searchRecurse(d, n.right);
    }

   
    public TreeNode searchIter(int key) {
        if (root.data == key)
            return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left != null)
                    current = current.left;
            } else {
                if (current.right != null)
                    current = current.right;
            }
            if (current.data == key)
                return current;
            /* your code 8 */
            else {
                if (current.left == null && current.right == null) {
                    return null;
                }
            }
        } //while
        return null;
    }
}