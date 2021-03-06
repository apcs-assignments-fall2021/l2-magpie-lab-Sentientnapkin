import java.util.Locale;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Me you converse like monkey.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement,"no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement,"dog") >= 0
                || findWord(statement,"cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement,"Nathan") >= 0
                || findWord(statement,"Lin") >= 0)
        {
            response = "He sounds cool!";
        }
        else if (findWord(statement,"Bruno") >= 0
                || findWord(statement,"do Val Callao") >= 0)
        {
            response = "He is probably very muscular!";
        }
        else if (findWord(statement,"Mario") >= 0
                || findWord(statement,"Chris Pratt") >= 0)
        {
            response = "Chris Pratt is Mario in the new movie.";
        }
        else if (findWord(statement,"shorts") >= 0
                || findWord(statement,"short pants") >= 0)
        {
            response = "I hate shorts.";
        }
        else if (findWord(statement,"hate") >= 0)
        {
            response = "Woah woah woah, hold on there, hate is a strong word.";
        }
        else if (findWord(statement,"I want ") >= 0)
        {
            statement=statement.toLowerCase();
            response = (transformIWantStatement(statement));
        }
        else if (findWord(statement,"I want to ") >= 0)
        {
            statement=statement.toLowerCase();
            response = (transformIWantToStatement(statement));
        }
        else if (findWord(statement, "I")>=0&&findWord(statement, "you")>=0&&findWord(statement, "I")<=findWord(statement, "you"))
        {
            statement=statement.toLowerCase();
            response = (transformIYouStatement(statement));
        }
        else if (findWord(statement, "you")>=0&&findWord(statement, "me")>=0&&findWord(statement, "you")<=findWord(statement, "me"))
        {
            statement=statement.toLowerCase();
            response = (transformYouMeStatement(statement));
        }
        else if (findWord(statement, "Would you rather")>=0&&findWord(statement, "or")>=0&&findWord(statement, "Would you rather")<=findWord(statement, "or"))
        {
            statement=statement.toLowerCase();
            response = (transformWouldYouRather(statement));
        }
        else if (statement.trim().length()<1)
        {
            response = "Could you write something next time?";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "But is it really?";
        }
        else if (whichResponse == 5)
        {
            response = "I'm not sure.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        System.out.println(str);
        str = " "+str.toUpperCase()+" ";
        word = " "+word.toUpperCase()+" ";
        return str.indexOf(word);
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        return "Would you really be happy if you had"+statement.substring((findWord(statement,"i want ")+7))+"?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        return "Why do you " +statement.substring(findWord(statement, "i")+2, findWord(statement, "you")-1)+" me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        return "What would it mean to"+statement.substring((findWord(statement,"i want to ")+10))+"?";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        return "What makes you think that I " +statement.substring(findWord(statement, "you")+4, findWord(statement, "me")-1)+" you?";

    }
    public String transformWouldYouRather(String statement)
    {
        double ran = (Math.random()*2)+1;
        if (ran == 1)
            return "i would prefer " +statement.substring(findWord(statement, "rather")+7, findWord(statement, "or")-1)+" .";
        else
            return "i would prefer " +statement.substring(findWord(statement, "or")+7)+" .";

    }
}
