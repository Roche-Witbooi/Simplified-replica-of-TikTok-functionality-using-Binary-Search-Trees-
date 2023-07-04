/** Binary Tree Data Structure 
  * @author Hussein Suleman
  * 26 March 2017
  */
import java.util.ArrayList;

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
  /** constructor Binary Tree 
    * creates an empty Binary Tree
    */ 
   public BinaryTree ()
   {
      root = null;
   }
   
  /** default method returns the height of the Binary Tree 
    * @return Integer height of the Binary Tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   
  /** method returns the height of the Binary Tree
    * @param node Binary Tree Node of which height is to be determined
    * @return Integer height of the Binary Tree for the Binary Tree Node provided
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)                     //The tree is empty
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   
  /** default method returns the size(number of Nodes) of the Binary Tree
    * @return Integer number of nodes in the Binary Tree
    */
   public int getSize ()
   {
      return getSize (root);
   } 
   
  /** method returns the size(number of Nodes) of the Binary Tree
    * @param  Node at the root of binary tree of which the number of nodes is to be determined
    * @return Integer number of nodes in the Binary Tree
    */  
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)                   // The tree is empty = has no nodes
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
  /** method which prints the main object of the current Binary Tree Node to the Screen
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
  /** default method prints all the obects in the Binary Tree in by first printing the value of the 
    * root node, followed by the left child, then right
    */ 
   public void preOrder ()
   {
      preOrder (root);
   }
   
  /** method prints all the obects in the Binary Tree in by first printing the value of the 
    * root node, followed by the left child, then right
    * @param root Binary Tree Node
    */ 
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   
  /** default method prints all the obects in the Binary Tree in by first printing the value of the 
    * left child, followed by the right child, then root node object
    */ 
   public void postOrder ()
   {
      postOrder (root);
   }
   
  /** method prints all the obects in the Binary Tree in by first printing the value of the 
    * left child, followed by the right child, then root node objec
    * @param root Binary Tree Node
    */ 
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   
  /** default method prints all the obects in the Binary Tree in by first printing the value of the 
    * left child, followed by the root node object, then the right child
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
  /** method prints all the obects in the Binary Tree in by first printing the value of the 
    * left child, followed by the root node object, then the right child
    * @param root Binary Tree Node
    */ 
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   
  /** default method copies all the obects in the Binary Tree to an ArrayList in by first copying the value of the 
    * left child, followed by the root node object, then the right child
    */
   public ArrayList<dataType> inOrderArrayList ( )
   {
      ArrayList<dataType>  listBTN = new ArrayList<dataType>();
      inOrderArrayList (root,listBTN);
      return listBTN;
   }   

  /** method copies all the obects in the Binary Tree to an ArrayList in by first copying the value of the 
    * left child, followed by the root node object, then the right child
    * @param root node of the Binary Tree which objects are to be copied to the arraylist
    * @param ArrayList to which the objects are being copied to
    */
   public ArrayList<dataType> inOrderArrayList ( BinaryTreeNode<dataType> node, ArrayList<dataType> listBTN )
   {      if (node != null)
      {
         inOrderArrayList (node.getLeft (),listBTN);
         listBTN.add(node.data);
         inOrderArrayList (node.getRight (),listBTN);
      }   
      
      return listBTN;
   }   
      
  /** method prints all the obects in the Binary Tree as they appear from 
    * left to right regardless of height using a Binary Tree Queue
    */
   public void levelOrder ()
   {
      if (root == null)                              // the tree is empty
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
