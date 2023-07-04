/** Generic Binary Tree Node 
  * @author Hussein Suleman
  * 26 March 2017
  */

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
  /** constructor Binary Tree Node
    * @param d    Data Type that the binary Tree should store.
    * @param l    Binary Trees left child Node .
    * @param r    Binary Trees right child Node .
    */ 
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
  /** accessor method for node left child
    * @return     The current Nodes left child.
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   
  /** accessor method for node right child
    * @return     The current Nodes right child.
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
