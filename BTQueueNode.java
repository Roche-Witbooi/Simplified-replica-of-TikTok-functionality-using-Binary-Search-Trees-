/** Queue node used in binary Tree Queue.
  * @author Hussein Suleman
  * 26 March 2017
  */

public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
  /** constructor Binary Tree Queue Node
    * @param n    Binary tree Node with data .
    * @param nxt  Next Binary tree Node in the Queue .
    */ 
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
