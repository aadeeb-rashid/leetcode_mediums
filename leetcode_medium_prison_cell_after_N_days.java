
// Prison Cells After N days:


// There are 8 prison cells in a row and each cell is either occupied or vacant.

// Each day, whether the cell is occupied or vacant changes according to the following rules:

//    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
//    Otherwise, it becomes vacant.




class Solution 
{
    public int[] prisonAfterNDays(int[] cells, int N) 
    {
        int[] cells2 = new int[cells.length];
            for(int i = 0; i < cells.length; i++)
            {
                if(i == 0 || i == cells.length-1)
                    cells2[i] = 0;
                else
                {
                    if(cells[i-1] == cells[i+1])
                        cells2[i] = 1;
                    else
                        cells2[i] = 0;
                }
            }
            cells = cells2;
        N--;
        N = (N % 14);
        int[] temp = new int[cells.length];
        for(int k = 0; k < N; k++)
        {
            cells2 = new int[cells.length];
            for(int i = 0; i < cells.length; i++)
            {
                if(i == 0 || i == cells.length-1)
                    cells2[i] = 0;
                else
                {
                    if(cells[i-1] == cells[i+1])
                        cells2[i] = 1;
                    else
                        cells2[i] = 0;
                }
            }
            cells = cells2;
            if(k == 0)
                temp = Arrays.copyOf(cells, cells.length);
            if(Arrays.equals(temp, cells))
                System.out.println(k);
        }
        return cells;
    }
}
