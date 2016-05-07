/*
 * by: Kevin Chumbley and Richard Norman
*/
package ACTBS;

import java.util.ArrayList;
import java.util.Iterator;

enum ColorOutput {

	ANSI_RESET(0),
	ANSI_BLACK(30),
	ANSI_RED(31),
	ANSI_GREEN(32),
	ANSI_YELLOW(33),
	ANSI_BLUE(34),
	ANSI_PURPLE(35),
	ANSI_CYAN(36),
	ANSI_WHITE(37),
	ANSI_BRIGHT_BLACK(38),
	ANSI_BRIGHT_RED(39),
	ANSI_BRIGHT_GREEN(40),
	ANSI_BRIGHT_YELLOW(41),
	ANSI_BRIGHT_BLUE(42),
	ANSI_BRIGHT_PURPLE(43),
	ANSI_BRIGHT_CYAN(44),
	ANSI_BRIGHT_WHITE(45);
	
	

	private int color = 1;

	private ColorOutput(final int color){
		this.color = color;
	}

	public String toString(){
		String res = "";
		if(System.console()!=null) {
			res+=this.toCode();
		}
		switch(this){
		case ANSI_RESET:
			res += "RESET";
			break;
		case ANSI_BLACK:
			res +=  "BLACK";
			break;
		case ANSI_RED:
			res +=  "RED";
			break;
		case ANSI_GREEN:
			res +=  "GREEN";
			break;
		case ANSI_YELLOW:
			res +=  "YELLOW";
			break;
		case ANSI_BLUE:
			res +=  "BLUE";
			break;
		case ANSI_PURPLE:
			res +=  "PURPLE";
			break;
		case ANSI_CYAN:
			res += "CYAN";
			break;
		case ANSI_WHITE:
			res +=  "WHITE";
			break;
		case ANSI_BRIGHT_BLACK:
			res +=  "BRIGHT_BLACK";
			break;
		case ANSI_BRIGHT_RED:
			res +=  "BRIGHT_RED";
			break;
		case ANSI_BRIGHT_GREEN:
			res +=  "BRIGHT_GREEN";
			break;
		case ANSI_BRIGHT_YELLOW:
			res +=  "BRIGHT_YELLOW";
			break;
		case ANSI_BRIGHT_BLUE:
			res +=  "BRIGHT_BLUE";
			break;
		case ANSI_BRIGHT_PURPLE:
			res +=  "BRIGHT_PURPLE";
			break;
		case ANSI_BRIGHT_CYAN:
			res += "BRIGHT_CYAN";
			break;
		case ANSI_BRIGHT_WHITE:
			res +=  "BRIGHT_WHITE";
			break;
		default:
			return " Color not Found ";
		}
		return res+= ANSI_RESET.toCode();
	}

	protected String toCode(){
		String res = "";
		if(System.console()==null) {
			//System.out.println(System.console());
			return res;
		}
		res += (char)27+"\u001B[";
		switch(this){
		case ANSI_RESET:
			res += "0";//(char)27+"\u001B[0m";
			break;
		case ANSI_BLACK:
			res +=  "30";//(char)27+"\u001B[30m";
			break;
		case ANSI_RED:
			res +=  "31";//"(char)27+\u001B[31m";
			break;
		case ANSI_GREEN:
			res +=  "32";//"(char)27+\u001B[32m";
			break;
		case ANSI_YELLOW:
			res +=  "33";//"(char)27+\u001B[33m";
			break;
		case ANSI_BLUE:
			res +=  "34";//"(char)27+\u001B[34m";
			break;
		case ANSI_PURPLE:
			res +=  "35";//"(char)27+\u001B[35m";
			break;
		case ANSI_CYAN:
			res +=  "36";//"(char)27+\u001B[36m";
			break;
		case ANSI_WHITE:
			res +=  "37";//"(char)27+\u001B[37m";
			break;
		case ANSI_BRIGHT_BLACK:
			res +=  "1;30";//(char)27+"\u001B[30m";
			break;
		case ANSI_BRIGHT_RED:
			res +=  "1;31";//"(char)27+\u001B[31m";
			break;
		case ANSI_BRIGHT_GREEN:
			res +=  "1;32";//"(char)27+\u001B[32m";
			break;
		case ANSI_BRIGHT_YELLOW:
			res +=  "1;33";//"(char)27+\u001B[33m";
			break;
		case ANSI_BRIGHT_BLUE:
			res +=  "1;34";//"(char)27+\u001B[34m";
			break;
		case ANSI_BRIGHT_PURPLE:
			res +=  "1;35";//"(char)27+\u001B[35m";
			break;
		case ANSI_BRIGHT_CYAN:
			res +=  "1;36";//"(char)27+\u001B[36m";
			break;
		case ANSI_BRIGHT_WHITE:
			res +=  "1;37";//"(char)27+\u001B[37m";
			break;
		default:
			return " Color not Found ";
		}
		return res+"m";
	}

	protected int getColor() {
		return color;
	}

	protected void setColor(int color) {
		this.color = color;
	}	

	protected static ArrayList<ColorOutput> getMyColors() {
		ArrayList<ColorOutput> colors = new ArrayList<>();
		for(ColorOutput c: ColorOutput.values())
			if(!c.toString().contains("RESET")
			&& !c.toString().contains("BLACK")
			&& !c.toString().contains("BRIGHT"))
				colors.add(c);
		return colors;
	}

	protected static ArrayList<ColorOutput> getBrightColors() {
		ArrayList<ColorOutput> colors = new ArrayList<>();
		for(ColorOutput c: ColorOutput.values())
			if(c.toString().contains("BRIGHT")
		   && !c.toString().contains("BLACK")
		   && !c.toString().contains("RESET"))
				colors.add(c);
		return colors;
	}
	
	private static Iterator<ColorOutput> colorItr  = ColorOutput.getMyColors().iterator();
	
	protected static String colorString(String str){
		if(System.console()==null)
			return str;
		if(!colorItr.hasNext())
			colorItr = ColorOutput.getMyColors().iterator();
		return colorItr.next().toCode() + str;
	}
	
}



