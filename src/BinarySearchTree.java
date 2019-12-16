public class BinarySearchTree {
    public static  Node root;
    public BinarySearchTree(){
        this.root = null;
    }

    public boolean delete(int key){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.data!=key){
            parent = current;
            if(current.data>key){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode){
        Node successsor =null;
        Node successsorParent =null;
        Node current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void insert(int key){
        Node newNode = new Node(key);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(key<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void inOrderTraverseTree(Node root) {
        if(root != null) {
            inOrderTraverseTree(root.left);
            System.out.print(" " + root.data);
            inOrderTraverseTree(root.right);
        }
    }

    public void preOrderTraverseTree(Node root) {
        if(root != null) {
            System.out.print(" " + root.data);
            preOrderTraverseTree(root.left);
            preOrderTraverseTree(root.right);
        }
    }

    public void postOrderTraverseTree(Node root) {
        if(root != null) {
            postOrderTraverseTree(root.left);
            postOrderTraverseTree(root.right);
            System.out.print(" " + root.data);
        }
    }

    public static void main(String arg[]){
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Original Tree : 50 62 15 5 20 51 91 3 10 37 24");
        tree.insert(50);
        tree.insert(62);
        tree.insert(15);
        tree.insert(5);
        tree.insert(20);
        tree.insert(51);
        tree.insert(91);
        tree.insert(3);
        tree.insert(10);
        tree.insert(37);
        tree.insert(24);
        System.out.print(" - In Order :");
        tree.inOrderTraverseTree(tree.root);
        System.out.print("\n - Pre Order :");
        tree.preOrderTraverseTree(tree.root);
        System.out.print("\n - Post Order :");
        tree.postOrderTraverseTree(tree.root);

        System.out.println("\n\nDelete 10 : " + tree.delete(10));
        System.out.print(" - In Order :");
        tree.inOrderTraverseTree(tree.root);
        System.out.print("\n - Pre Order :");
        tree.preOrderTraverseTree(tree.root);
        System.out.print("\n - Post Order :");
        tree.postOrderTraverseTree(tree.root);

        System.out.println("\n\nDelete 60 : " + tree.delete(60));
        System.out.println("Delete 15 : " + tree.delete(15));
        System.out.print(" - In Order :");
        tree.inOrderTraverseTree(tree.root);
        System.out.print("\n - Pre Order :");
        tree.preOrderTraverseTree(tree.root);
        System.out.print("\n - Post Order :");
        tree.postOrderTraverseTree(tree.root);
    }
}

