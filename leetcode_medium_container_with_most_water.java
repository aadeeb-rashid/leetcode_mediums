
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.


import java.lang.Math;
class Solution 
{
    public int maxArea(int[] height) 
    {
        int max = 0;
        for(int i = 0; i < height.length; i++)
        {
            for(int k = i+1; k < height.length; k++)
            {
                int y = Math.min(height[i], height[k]);
                int x = k - i;
                int area = x * y;
                if(area > max)
                    max = area;
            }
        }
        return max;
        
    }
}
