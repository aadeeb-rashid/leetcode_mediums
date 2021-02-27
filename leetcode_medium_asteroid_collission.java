// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

import java.lang.Math;
import java.util.*;
class Solution 
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> pos = new Stack<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int index = 0;
        for(int i = 0; i < asteroids.length; i++)
        {
            if(asteroids[i] > 0)
                break;
            index++;
        }
        int j = 0;
        int[] real_asteroids = new int[asteroids.length-index];
        for(int i = index; i < asteroids.length; i++)
            real_asteroids[j++] = asteroids[i];
        for(int i = 0; i < real_asteroids.length; i++)
        {
            if(real_asteroids[i] > 0)
                pos.push(real_asteroids[i]);
            else if(!pos.isEmpty())
            {
                if(Math.abs(real_asteroids[i]) > pos.peek())
                {
                    while(!pos.isEmpty() && Math.abs(real_asteroids[i]) > pos.peek() )
                        pos.pop();
                    if(!pos.isEmpty() && Math.abs(real_asteroids[i]) == pos.peek())
                        pos.pop();
                    else if(!pos.isEmpty() && Math.abs(real_asteroids[i]) < pos.peek())
                        continue;
                    else
                        asteroids[index++] = real_asteroids[i];
                }
                else if(pos.peek() > Math.abs(real_asteroids[i]))
                    continue;
                else
                    pos.pop();
            }
            else
                asteroids[index++] = real_asteroids[i];
        }
        while(!pos.isEmpty())
            temp.add(pos.pop());
        Collections.reverse(temp);
        while(!temp.isEmpty())
            asteroids[index++] = temp.remove(0);
        int[] res = new int[index];
        for(int i = 0; i < res.length; i++)
            res[i] = asteroids[i];
        return res;
        
        
    }
}
