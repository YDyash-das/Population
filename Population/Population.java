
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *	Population - Sorts a wide range of states and citties by different
 * catorgies with different sorts.
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Yash Das
 *	@since	1/9/23
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";

	public Population()
	{
		cities = new ArrayList<City>();
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
		System.out.println("31765 cities in database");
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	public static void main(String[] args)
	{
		Population ppl = new Population();
		ppl.start();
	}
	
	/**
	 *  Calls other methods  
	 */
	public void start()
	{
		readFile();
		printIntroduction();
		userInput();

	}
	/** 
	 * Asks for user chose and calls methods accordingly 
	 */
	public void userInput()
	{
		for(int i =0; i>-1; i++)
		{
			System.out.println();
			printMenu();
			int choice = Prompt.getInt("Enter Selection");
			if(choice ==1)
			ascendingPopulation();
			else if(choice ==2)
			descendingPopulation();
			else if(choice == 3)
			ascendingName();
			else if(choice ==4)
			descendingName();
			else if( choice == 5)
			{
				String state = "";//choosen state
				for(int j =2; j >1; j++){
					state = Prompt.getString("Enter State name (ie. Alabama)");
					j = isState(state);
				}
				System.out.println();
				mostPopulous(state);
			}
			else if(choice == 6)
			{	String city = "";//choosen city
				for(int j =2; j > 1; j++){
					city = Prompt.getString("\nEnter city name");
					j = isCity(city);
				}
				System.out.println();
				matchPopulation(city);
			}
			
			else if(choice == 9)
			{
				System.out.println();
				System.out.println("Thanks for using Population!");
				return;
			}	
		}

	}
	/**
	 * Checks if city is in the list
	 * @param cityIn the choosen city
	 * @return number representing if the city is valid
	 */
	public int isCity(String cityIn)
	{
		for(int i =0; i<cities.size(); i++)
		{
			if(cities.get(i).getName().equals(cityIn))
			{
				
				return -1;
			}
		}
		System.out.println("ERROR: "+cityIn+" is not valid");
		return 1;
	}
	/**
	 * Checks if state is in the list
	 * @param stateIn the choosen state
	 * @return number representing if the state is valid
	 */
	public int isState(String stateIn)
	{
	
		for(int i =0; i<cities.size(); i++)
		{
			if(cities.get(i).getState().equals(stateIn))
			{
				
				return -1;
			}
		}
		System.out.println("ERROR: "+stateIn+" is not valid");	
		return 1;
	}

	/** 
	 * Reads the file and stores in list
	 */
	public void readFile()
	{   
        String tempC= ""; 
        String tempS = "";
        int tempP = 0;
        String tempT = "";
		Scanner input = FileUtils.openToRead(DATA_FILE);
		while(input.hasNext())
		{
           
			String line = input.nextLine();
			Scanner s = new Scanner(line).useDelimiter("[\t\n]");
			tempS = s.next();
			tempC = s.next();
			tempT = s.next();
			tempP = s.nextInt();
			cities.add(new City(tempS, tempC, tempT, tempP));
		}
	}
	
	/**
	 * Uses selection sort to sort the least populated cities
	 */
	public void ascendingPopulation()
    {
		System.out.println("\n");
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.selectionSort(cities);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Fifty least populous cities");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; i<50; i ++)
		{
			System.out.printf("%3s: %-25s %-25s %-25s %,12d", i+1, aP.get(i).getState(), aP.get(i).getName(), aP.get(i).getType(), aP.get(i).getPopulation());
			System.out.println();
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");
    }

	/**
	 * Uses merge sort to sort cities by population
	 */
    public void descendingPopulation()
    {
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.mergeSort(cities,1);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Fifty most populous cities");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; i<50; i ++)
		{
			System.out.printf("%3s: %-25s %-25s %-25s %,12d", i+1, 
			aP.get(i).getState(), aP.get(i).getName(), aP.get(i).getType(), 
			aP.get(i).getPopulation());
			System.out.println();
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");
	}
	/**
	 * Uses insertion sort to sort first 50 cities by name
	 */
    public void ascendingName()
    {
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.insertionSort(cities);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Fifty cities sorted by name");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; i<50; i ++)
		{
			System.out.printf("%3s: %-25s %-25s %-25s %,12d", i+1, aP.get(i).
			getState(), aP.get(i).getName(), aP.get(i).getType(), aP.get(i).
			getPopulation());
			System.out.println();
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");

	}
	/** 
	 * Uses merge sort to sort last 50 cities by name
	 */
    public void descendingName()
    {
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.mergeSort(cities,2);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Fifty cities sorted by name descending");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; i<50; i ++)
		{
			System.out.printf("%3s: %-25s %-25s %-25s %,12d", i+1, aP.get(i).
			getState(), aP.get(i).getName(), aP.get(i).getType(), aP.get(i).
			getPopulation());
			System.out.println();
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");
	}
	/**
	 * Uses merge sort to sort cities in choosen state by population
	 * @param stateIn the choosen state
	 */
    public void mostPopulous(String stateIn)
    {   
		int index = 0;// number of lines printed
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.mergeSort(cities,1);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Fifty most populous cities in California");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; index<50 && i<aP.size(); i ++)
		{
			if(aP.get(i).getState().equals(stateIn))
			{
				System.out.printf("%3s: %-25s %-25s %-25s %,12d", index+1,
				aP.get(i).getState(), aP.get(i).getName(), aP.get(i).getType(),
				aP.get(i).getPopulation());
				System.out.println();
				index++;
			}
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");
    }
	/** 
	 * Uses merge sort to sort the 1 city name by population
	 * @param cityIn the choosen city
	 */
    public void matchPopulation(String cityIn)
    {
		int index = 0;// number of lines printed
		SortMethods sms = new SortMethods();
		List<City> aP = new ArrayList<City>();
		long startMillisec = System.currentTimeMillis();
		aP = sms.mergeSort(cities,1);
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("City " +cityIn + " by population");
		System.out.printf("%10s %24s %25s %33s", "State","City", "Type", "Population" );
		System.out.println();
		for(int i =0; i<aP.size(); i ++)
		{
			if(aP.get(i).getName().equals(cityIn))
			{
				System.out.printf("%3s: %-25s %-25s %-25s %,12d", index+1, 
				aP.get(i).getState(), aP.get(i).getName(), aP.get(i).getType(), 
				aP.get(i).getPopulation());
				System.out.println();
				index++;
			}
		}
		System.out.println("\nElapsed Time "+ endMillisec + " milliseconds");
    }


	
}
