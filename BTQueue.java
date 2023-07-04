/** Queue of Binary Tree Nodes 
  * Used in Binary Tree Level Order Traversal
  * @author Hussein Suleman
  * 26 March 2017
  */

public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
   
  /** constructor Binary Tree Queue.
    */   
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
  /** Returns the Binary Tree node at the end of the Queue
    * @return  Binary Tree Node at the end of the Queue
    */ 
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)                      //returns null if the Queue is empty
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;                     
   }
   
  /** Method that adds a Node from the Binary Tree to the Binary Tree Queue
    * @param  Binary Tree Node that is to be added to the Queue
    */    
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);      //Adds the first node of the Queue      
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);//Adds new node to the Queue
         tail = tail.next;
      }   
   }   
}
