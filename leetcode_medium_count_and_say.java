
// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

//    countAndSay(1) = "1"
//    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.

// To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.


class Solution 
{
    public String countAndSay(int n) 
    {
        if(n == 1)
            return "1";
        String last = countAndSay(n-1), res = "";
        char test = last.charAt(0);
        int count = 0;
        for(int i = 0; i < last.length(); i++)
        {
            if(test == last.charAt(i))
                count++;
            else
            {
                res+= count;
                res+= test;
                test = last.charAt(i);
                count = 1;
            }
        }
        res+= count;
        res+= test;
        return res;
        
    }
}
