

public class Cell
{
    private boolean mine;
    private int numAdjMines;


    public Cell(char c)
    {
	this.mine = false;
	
	if(c == '*')
	    this.mine = true;
	
	numAdjMines = 0;
    }

    public boolean isMine()
    {
	return mine;
    }


    public void incAdjMines()
    {
	numAdjMines++;
    }

    public void setMine()
    {
	mine = true;
    }

    public int getNumMines()
    {
	return numAdjMines;
    }

    public void resetCell()
    {
	mine = false;
	numAdjMines = 0;
    }

}
