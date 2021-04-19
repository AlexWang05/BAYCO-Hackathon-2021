import java.util.ArrayList;

/**
 * Used to store data (strings) for the Linksaver, retrieve the data, as well as alter it
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/17/2021
 */
public class Data {
	
	private static ArrayList<String> strings = new ArrayList<String>();

	/**
	 * Creates a data object
	 * 
	 * @param num number required for how many strings to store in data
	 */
	public Data(int num)
	{
		for(int i = 0; i < num; i++)
		{
			strings.add("");
		}
	}
	
	/**
	 * Replaces a specified string in the data object
	 * 
	 * @param num string index that will be replaced
	 * @param s new string to replace old string at index num
	 */
	public void replaceStrings(int num, String s)
	{
		strings.remove(num);
		strings.add(num,s);
	}
	
	/**
	 * Returns all strings in a Data object
	 * @return arraylist of strings (number specified when initialized)
	 */
	public ArrayList<String> returnStrings()
	{
		return strings;
	}
	
	/**
	 * Returns string for one tile in homeGui
	 * 
	 * @param n number for index of line going to be retrieved in the Data object
	 * @return requested string
	 */
	public String getFullString(int n) {
		return strings.get(n);
	
	}
	
	/**
	 * Gets the course name for one tile in homeGui
	 * 
	 * @pre only zero or two ';' are used in the string
	 * @param n number for index of line going to be retrieved in the Data object
	 * @return course name at specified index
	 */
	public static String getCourseName(int n)
	{
		String s = strings.get(n);	
		if(s.indexOf(';') != -1) {
			return s.substring(0, s.indexOf(';'));
		} 
		else {
			return "";
		}
		
	}
	
	/**
	 * Gets the course link for one tile in homeGui
	 * 
	 * @pre only zero or two ';' are used in the string
	 * @param n number for index of line going to be retrieved in the Data object
	 * @return course name at specified index
	 */
	public String getCourseLink(int n)
	{
		String s = strings.get(n);
		if(s.indexOf(';') != -1 && s.lastIndexOf(';') != -1)
		{
			return s.substring(s.indexOf(';')+1, s.lastIndexOf(';'));
		} 
		else {
			return "";
		}
	}
	
	/**
	 * Gets the meeting link for one tile in homeGui
	 * 
	 * @pre only zero or two ';' are used in the string
	 * @param n number for index of line going to be retrieved in the Data object
	 * @return course name at specified index
	 */
	public String getMeetingLink(int n)
	{
		String s = strings.get(n);
		if(s.lastIndexOf(';') != -1) {
			return s.substring(s.lastIndexOf(';')+1);
		} 
		else {
			return "";
		}
	}
	
	/**
	 * (Dev. test) used to print strings in console
	 */
	public void printStrings()
	{
		for(String s : strings)
		{
			System.out.println(s);
		}
	}
}