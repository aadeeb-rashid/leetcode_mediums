

// Given a string s, find the length of the longest substring without repeating characters.


class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() == 0)
            return 0;
        int max = 1;
        
        for(int i = 0; i < s.length(); i++)
        {
            int count = 0;
            String s2 = s.substring(i);
            for(int k = 0; k < s2.length(); k++)
            {
                if(s2.indexOf(s2.charAt(k)) == k)
                    count++;
                else
                {
                    if(count > max)
                        max = count;
                    break;
                }       
            }
            if(count > max)
                max = count;
        }
        return max;
    }
}



