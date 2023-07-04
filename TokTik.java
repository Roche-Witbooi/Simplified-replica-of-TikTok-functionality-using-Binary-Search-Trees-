/** TokTik user account management program
  * Allows the user to
  * 1. Find the profile description for a given account 
  * 2. List all accounts 
  * 3. Create an account 
  * 4. Delete an account 
  * 5. Display all posts for a single account 
  * 6. Add a new post for an account 
  * 7. Load a file of action from disk and process this 
  * @author Roche Witbooi
  * date 8 April 2023
  */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;


public class TokTik
{   
   public static void main ( String [] args )
   {
      BinarySearchTree<Account> bt = new BinarySearchTree<Account> ();
     	int choice = 0;
     
	
	   /** User selects which action they would like to perform in the 
	     * range 1-8
	     */
       	while (choice != 8)
    	      {	Scanner  input  = new Scanner(System.in);
        	         System.out.print( "\nChoose an action from the menu: \n"+
                          "1. Find the profile description for a given account \n"+
                          "2. List all accounts \n"+
                          "3. Create an account \n"+
                          "4. Delete an account \n"+
                          "5. Display all posts for a single account \n"+
                          "6. Add a new post for an account \n"+
                          "7. Load a file of action from disk and process this \n"+
                          "8. Quit \n\n"+
                          "9. Follow an account\n"+
                          "10. Recommend accounts to follow \n"+
                          "11. Account summary\n\n"+
                          "Enter your choice (1-11): ");
                          
                     // Validates if the selection is an integer 
                     try 
                     {         
       	               choice = input.nextInt();
                     }
                     catch (InputMismatchException ex)
                     {
       	                System.out.println("\nPlease enter a number from 1-11\n");   continue;
                  	    
                     }
       
                    // Validates if the selection is in range 1-11
                     if (choice < 1 || choice > 11)
                     {
                        System.out.println("\nSelect an option (1-11)\n");
                        continue;
                     }
       
                     switch (choice)
                     {
                         case 1:   // Selection 1: find profile description for a given account
                             	     System.out.print("Enter the account name: ");
              	                    Account fndAcc = TokTikHelper.accInputValid(input);
              	
                                   //Determines if the account entered exists
                                   if (bt.find(fndAcc) != null)
                                      { System.out.print("\nThe profile description is : "+ bt.find(fndAcc).data.getDescription ()+"\n");}  
                                   else 
                                      { System.out.print("\nNo account "+fndAcc.getUsername ()+ " found."+"\n"); }
                                   break;
                                   
                          case 2:   // Selection 2: List all accounts
                                   if ( bt.root == null)
                                       { System.out.print("\nThere are no accounts listed\n"); }
                                   else
                                      {   System.out.print("\nAccount username followed by description\n");
                                         bt.inOrder(); }
                                   break;
                                                        
                          case 3:   //Selection 3: Create an account
                                    System.out.print("Enter username of the new user: ");
                                    Account crtAcc = TokTikHelper.accInputValid(input);   
                                                
                                    //Determines if account already exists
                                    if (bt.find(crtAcc)== null)
                                       {
                                             System.out.print("Enter the profile description: ");
                                             String crtDescrip = TokTikHelper.lineInputValid( input);;
                                             bt.insert(new Account(crtAcc.getUsername(),crtDescrip));
                                             System.out.println(crtAcc.getUsername()+ " account successfully created\n");
                                        }
                                    else 
                                        { System.out.print("\nAn account with this username already exists. Please try again.\n"); }
                                    break;
               
                           case 4:   //Selection 4: Delete an account
                                     System.out.print("Enter name of the user you wish to delete: ");
                                     Account delAcc = TokTikHelper.accInputValid(input);  
                                     
                                     //Determines if account exists
                                     if (bt.find(delAcc) == null )
                                       { System.out.print("\nThe account you wish to delete does not exist \n"); }
                                     else 
                                       {
                                               // Confirm account deletion               
                                                  System.out.print("\nAre you sure you would like to delete this account (y/n)? :");  
                                                  String delCon = TokTikHelper.singStrInputValid(input);   
		         	                                if (delCon.equals("y"))
			                                           {
			            	                                 bt.delete(bt.find(delAcc).data);
                                                         System.out.print("\nThe account of user: "+delAcc.getUsername ()+" has been deleted.\n");
			                                           }         
                                                	else
                                                	{ System.out.print("\nThe account deletion was unsuccesful\n"); }
                                       }
                                     break;
               
                            case 5:      //Selection 5: List all the posts for an account
                                          System.out.print("Enter account name: ");
                                          Account listAcc = TokTikHelper.accInputValid(input);
         
		                                     //Determines if the account exists              
                                          if (bt.find(listAcc) == null )
                                             { System.out.print("\nThe account does not exist \n"); }
                                          else 
                                             {            //Determines if the user has any posts
                                                          ArrayList<Post> posts = bt.find(listAcc).data.getPosts();
                                                          if (posts.isEmpty())
                                                             { System.out.print("\n"+listAcc.getUsername ()+" does not have any posts\n"); }
                                                          else 
                                                           {
                                                 	                for (int i = posts.size()-1; i>=0; i--)
              		                                                  { System.out.print(posts.get(i).toString()); }
                                                           }        
                                            }
                                            break;
           
           
	                            case 6:        //Selection 6: Adds a post for an account
                                              System.out.print("Enter account name: ");
                                              Account addPostAcc = TokTikHelper.accInputValid(input);

                                              //Determines if the account exists
                                              if (bt.find(addPostAcc) == null )
                                                  { System.out.print("The account does not exist \n"); }
                                              else 
                                                  {
			                                             //Obtains post information               
               	                                     System.out.print("Enter post name: ");
               	                                     String postName = TokTikHelper.lineInputValid( input);
                                                       System.out.print("Enter video name: ");
                                                       String vidName = TokTikHelper. singStrInputValid( input);
                                                       System.out.print("Enter number of likes: ");
                                                             try 
                                                               {
                                                                  int numLikes = input.nextInt();
                                                                  //Adds post
               	                                                BinaryTreeNode<Account> listAccountNode = bt.find(addPostAcc);
                                                                  listAccountNode.data.addPost(new Post(postName,vidName,numLikes));
                                                                }
                                                               catch (InputMismatchException ex)
                                                                { System.out.print("\nThe number of likes must be a an integer greater than 0\n"); }
                                                   }          
                                                   break;
               
	                              case 7:  // Adds posts and creates accounts based on file input
                                                    //Checks if the file exists
          	                                        try
          	                                          {
			                                                   System.out.print("Enter the file name: ");              
			                                                   String fileName = TokTikHelper.strInputValid( input);
           		                                             Scanner file = new Scanner(new File(fileName));
           	
           		                                              //Reads in each line of textfile
           		                                             while (file.hasNext())
           		                                             {
           			                                                 String line = file.nextLine();
           			                                                 String[] words = line.split(" ");
           			
           			                                                //Adds Post
                                                      	        if (words[0].equals("Add"))
           			                                                  {
           			                                                             Account addPostFileAcc = new Account (words[1]);
               			                                                       if (bt.find(addPostFileAcc) != null)
                			                                             	       {
                					                                                      Account newPostAccount = bt.find(addPostFileAcc).data;
                					                                                      String newVidDescription = "";
                					                                                       //Rebuilds Description from Array
               					                                                      for (int i = 4; i <words.length; i++)
           		 				                                                            { newVidDescription= newVidDescription+words[i]+" "; }
                                                                                    newPostAccount.addPost(new Post(newVidDescription,words[2],Integer.parseInt(words[3])));

                                                              				         }
                             			                                           else   //Account not found                			                                                         {
                                                                                 {  System.out.print("\nNo account "+words[1]+ " found."+"\n\n");}
                                                                                 
                                                                      }//Creates a new Account by file
           			                                                 else if (words[0].equals("Create"))
           			                                                    {	
           			                                                            String newFileDescription ="";
                                                                               // Reterives the full description
           		                                                                for (int i = 2; i<words.length; i++)
           		                                                                {
           		      	                                                             newFileDescription= newFileDescription+words[i]+" ";
           		                                                                 }
           		                                                                 Account newFileAccount = new Account(words[1], newFileDescription);
           		                                                                 bt.insert(newFileAccount);
           		                                                       }
           		                                                      else
           		                                                      { System.out.print("\n"+line+ " : this action is invalid"+"\nCommands must begin with Add/Create\n");}
                                                               }
                                                                file.close();
               	                        }
               	                      catch (FileNotFoundException e)
           		                           {
           			                              System.out.print("\nThe file was not found");
           		                           }
           		                         break;
                                                   
                                  case 9: // allows user to follow any account
                                          System.out.print("Enter your account name: ");
                                          Account followerAcc = TokTikHelper.accInputValid(input);
                                                    
		                                   //Determines if the account exists              
                                         if (bt.find(followerAcc) == null )
                                             { System.out.print("\nThe your account does not exist \n"); }
                                         else 
                                             {   //checks if the account to follow  exsist  
                                                 followerAcc = bt.find(followerAcc).data;   
                           			             System.out.print("Enter the account you wish to follow: ");
                                                 Account followAcc = TokTikHelper.secAccInputValid(input);  
                                                                                                   
                           		                       //Determines if the account exists              
                                                        if (bt.find(followAcc) == null )
                                                           { System.out.print("\nThe account you wish to follow does not exist \n"); }
                                                        else
                                                           {
                                                           followAcc = bt.find(followAcc).data; 
                                                           
                                                           //Determines if the user already follows the account
                                                               if (followAcc.getFollowers().find(followerAcc) == null)  
                                                                 {
                                                                   followAcc.addFollower(followerAcc);
                                                                   System.out.print("You now follow "+followAcc.getUsername()+"\n");
                                                                 }
                                                                 else
                                                                 {System.out.print("You already follow "+followAcc+"\n"); }                  
                                                           } 
                                              } 
                                         break;
                                                         
                                    case 10:	//Recommends accounts to follow
                                             //Checks if the account exists
                                               System.out.print("Enter your account name: ");
                                               Account usrAccRec = TokTikHelper.accInputValid(input);
                                                                 
		                                       //Determines if the account exists              
                                             if (bt.find(usrAccRec) == null )
                                              { System.out.print("\nThe your account does not exist \n");}
                                            else 
                                              {   
                                                   System.out.print("Enter a topic of interest (e.g cat): ");              
			                                          String interest = TokTikHelper. singStrInputValid( input); 
                                                                 
                                                      //Finds account corresponding to interest indescription
                                                       System.out.print("\nYou may want to follow these accounts: \n");
                                                       ArrayList<Account>  allAccounts = bt.inOrderArrayList ();
                                                       int found  =0;
                                                       for (int i = 0; i< allAccounts.size(); i++)
                                                       {    
                                                              if (allAccounts.get(i).getUsername().equals(usrAccRec.getUsername()))
                                                                 {}  
                                                             else if(usrAccRec.getFollowers().find(allAccounts.get(i))!= null)
                                                                 {}
                                                             else if (allAccounts.get(i).getDescription().toUpperCase().contains(interest.toUpperCase()))
                                                                 {
                                                                     System.out.println(allAccounts.get(i).toString()); 
                                                                      found++;
                                                                }
                                                        }   
                                                        
      
                                                        //Determines if any accounts of interest were found
                                                        if (found == 0)
                                                          { System.out.print("\nNo accounts of interest found"); }
                                                         else
                                                          { // Confirms follow request 
                                                             usrAccRec = bt.find(usrAccRec).data;              
                                                             System.out.print("\nWould you like to follow any of these accounts (y/n)? ");  
                                                             String followCon = TokTikHelper. singStrInputValid( input); 
		         	                                                     if (followCon.equals("y"))
			                                                                {
                                                                                        //Determines if the user already follows the account
			            	                                                               System.out.print("\nEnter the account name: ");
                                                                                        Account folAcc =  TokTikHelper.secAccInputValid(input);
                                                                                         if (bt.find(folAcc) == null )
                                                                                            { System.out.print("\nYou have entered the account username incorrectly \n");}
                                                                                         else 
                                                                                           {  
                                                                                              bt.find(folAcc).data.addFollower(usrAccRec);
                                                                                              System.out.print("\nYou now follow "+folAcc.getUsername());
                                                                                           }
                                                                          }
                                                                         else if (!followCon.equals("n"))
                                                                          { System.out.println("\n"+followCon + " is not a valid response \n"); }

                                                             }
                                                     }              
                                               break; 
                 
                 
                                           case 11:   //Obtains a summary of the accounts details
                                                     System.out.println("\nEnter your account name: ");
                                                     Account sumUsrAcc = TokTikHelper.accInputValid(input);
    
		                                                 //Determines if the account exists              
                                                         if (bt.find(sumUsrAcc) == null )
                                                          { System.out.println("The your account does not exist \n"); }
                                                          else  
                                                          {            //Determines the most popular post based on likes
                                                                       int popPost = 0;
                                                                       Account sumAcc = bt.find(sumUsrAcc).data;
                                                                       if (sumAcc.getPosts().isEmpty())
                                                                         {}
                                                                       else
                                                                         {
                                                                            for (int i= 0; i< sumAcc.getPosts().size(); i++)
                                                                             {
                                                                                   if (sumAcc.getPosts().get(i). getNumberLikes ()> sumAcc.getPosts().get(popPost). getNumberLikes ())
                                                                                    popPost = i ;
                                                                             }
                                                                         }
                                                                             
                                                                        //Determines how many account current account is following
                                                                        ArrayList<Account>  allAccountbt = bt.inOrderArrayList ();
                                                                        int following  = 0;
                                                                                 if (allAccountbt.isEmpty())
                                                                                 {}
                                                                                 else
                                                                                 {
                                                                                     for (int i = 0; i< allAccountbt.size(); i++)
                                                                                        { 
                                                                                            if (allAccountbt.get(i).getFollowers().find(sumUsrAcc) != null)
                                                                                                   {following= following+1 ;}                                                               
                                                                                        } 
                                                                                  }

                                                                                   System.out.print(sumAcc.getUsername().toUpperCase()+ 
                                                                                   "\nWelcome to your account Summary: "+
                                                                                   "\nDescription: "+ sumAcc.getDescription());
                                                                                   
                                                                                   if (popPost == 0)
                                                                                   {System.out.print("\nTotal Posts: "+ sumAcc.getPosts().size());}
                                                                                   else
                                                                                   {System.out.print("\nTotal Posts: "+ sumAcc.getPosts().size()+"\nYour post popular post is: \n"+sumAcc.getPosts().get(popPost).toString());}
                                                                                  
                                                                                   System.out.print( "\nNumber of followers is : "+sumAcc.getFollowers().getSize());
                                                                                   System.out.print("\nNumber of accounts following: "+ following+"\n");
                                                                 }
                                                           break;  
                                       }//switch end
                               }//while end
                               System.out.println("\nBye!");
         }//main end
}//class end
