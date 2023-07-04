/** Binary Search Tree Data Structure, simplifies the process of finding objects
  * in a Binary Tree
  * @author Hussein Suleman
  * 26 March 2017
  */

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{

  /** method adds an object to the Binary Tree in its correct position
    * @param   the object that is to be inserted
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);            //instatiates binary tree if no tree exists
      else
         insert (d, root);
   }
   
  /** method adds an object to the Binary Tree in its correct position
    * @param   the object to being added to the Binary Tree
    * @param   the current node which is being check and compared to add the new object 
    */   
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)                                  // the value of the inserted object is smaller than the value in the node
      {
         if (node.left == null)                                         // inserts as the leaf of the left tree
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);   // inserts as the leaf of the right tree
         else
            insert (d, node.right);
      }
   }
   
  /** method searches for the provided object in the Tree and returns the node in which the object is stored
    * @param   the object to being searched for in the Binary Tree
    */ 
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
  /** method searches for the provided object in the Tree and returns the node in which the object is stored
    * @param   the object to being searched for in the Binary Tree
    * @param   the current node which is being check and compared to find the provided object
    * @return  The Binary Tree Node in which the provided object is stored
    *          null if the given object not found
    */  
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) == 0)                           //returns node containing the provided object
         return node;                       
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left); //searches left subtree if the value of the provided object is smaller 
      else
         return (node.right == null) ? null : find (d, node.right);//searches right subtree if the value of the provided object is bigger 
   }
   
  /** method removes for the provided object from the Tree 
    * @param   the object to be deleted from the Binary Tree
    */ 
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }  
   
  /** method removes for the provided object from the Tree and returns the node in which the object is stored
    * @param   the object to be deleted from the Binary Tree
    * @param   the current node which is being check and compared to deleted the provided object
    * @return  The removed Binary Tree Node with the provided object is stored
    *          null if the given object not found
    */  
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;                             
      if (d.compareTo (node.data) < 0)                 //searches left subtree if the value of the provided object is smaller 
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)            //searches right subtree if the value of the provided object is bigger 
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
  /** method  finds the minimuim object value in the Binary Tree
    * @param   the root node of the tree being searched for the minimium
    * @return  the Binary Tree Node with the object with the minimuim value in the tree
    */ 
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

  /** method   removes node storing the minimuim object value in the Binary Tree
    * @param   the root node of the tree being searched for the minimium
    * @return  the Binary Tree Node with the object with the minimuim value in the tree
    */ 
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
