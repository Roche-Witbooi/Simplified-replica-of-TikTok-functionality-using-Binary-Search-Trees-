/** Representation of a post from a TokTik user account containing  
  * post title, video name and number of likes 
  * @author Roche Witbooi
  * date 8 April 2023
  */

public class Post 
{
    private String title;         
    private String vidName;
    private int numLikes;
    
    /** constructor for the Post class.
      * @param title      the post title.
      * @param vidName    the videos full name.
      * @param numLikes   the number of likes a post contains.
      */    
    public Post( String title, String vidName, int numLikes)
    {
        this.title = title;
        this.vidName = vidName;
        this.numLikes = numLikes;
    }
    
    /** accessor method for title
      * @return     String with the title of the Post.
      */    
    public String getTitle (){ return this.title; }
    
    /** accessor method for video name
      * @return     String with the name of the video.
      */    
    public String getVidName (){ return this.vidName; }
    
    /** accessor method for number of likes
      * @return     Integer with the number likes the post has.
      */    
    public int getNumberLikes (){ return this.numLikes; }
    
    /** method converts Post to a string represenation of an Post
      * @return Title: <title> 
      *	       Video: <vidName>
      *	       Number of likes: <numLikes>
      */
    public String toString()
    {
         return "\nTitle: "+title +"\nVideo: "+ vidName+"\nNumber of likes: "+Integer.toString(numLikes)+"\n";
    }
}

