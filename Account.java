/** Representation of a TokTik user account containing username, 
  * account description and list of the users post. 
  * @author Hussein Suleman
  * @author adapted by Roche Witbooi
  *  date 8 April 2023
  */
import java.util.ArrayList;


public class Account implements Comparable <Account> 
{ 
    private String username;
    private String description;
    private ArrayList<Post> posts;
    private BinarySearchTree<Account> btFollowers;
     
   /** constructor for the Account class.
     * @param usr        the account username.
     */
   public Account (String usr)
   {
       this.username = usr;
       this.description = " ";
       this.posts = new ArrayList<Post>(); 
       this.btFollowers = new BinarySearchTree<Account> ();
   } 
   
    /** constructor for the Account class.
      * @param usr        the account username.
      * @param descrip    the account description.
      */
   public Account (String usr, String descrip)
   {
       this.username = usr;
       this.description = descrip;
       this.posts = new ArrayList<Post>(); 
       this.btFollowers = new BinarySearchTree<Account> ();
   } 
       
    /** constructor for the Account class.
      * @param usr        the account username.
      * @param descrip    the account description.
      * @param p          details about a post made by the user.
      */
   public Account (String usr, String descrip, Post p)
    {
        this.username = usr;
        this.description = descrip;
        this.posts = new ArrayList<Post>(); 
        this.btFollowers = new BinarySearchTree<Account> ();
        posts.add(p);
    } 
    
  /** Retreives username
    * @return account username
    */
   public String getUsername () { return this.username; } 
    
  /** Retreives description
    * @return account description
    */
   public String getDescription () { return this.description; } 
   
  /** Retreives all the posts made by the account
    * @return array list containing all the account posts
    */
   public ArrayList<Post> getPosts () { return this.posts; } 
   
   /** Retreives all the accounts followers
     * @return binary search tree containing followers of the account
     */
   public BinarySearchTree<Account> getFollowers () { return this.btFollowers; } 

  /** Determines if one account should comes before or after 
    * another depending on the alphabetical order of the username.
    * @param other      the other account to which the current account is being compared to.
    * @return           returns an integer value which explains the order
    *		   0 = Accounts have the same user name.
    *		   0 < Current account username comes before other 
    *			account username.
    *		   0 > Current account username comes after other 
    *			username in the alphabet.
    */        
   public int compareTo (Account other) {return username.compareTo (other.username); }
   
 
  /** method which adds a new post to an account
    * @param post that is created by the account
    */  
   public void addPost(Post p) { posts.add(p); }
   
  /** method which adds a new follower to an account
    * @param account of the follower
    */ 
   public void addFollower(Account a) { this.btFollowers.insert(a); }
    
    /** Converts account class to a string represenation of an Account
      * @return <username> <account description>
      */
    public String toString () { return this.username +" "+this.description; }
           
}
