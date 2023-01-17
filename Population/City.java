

/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Yash Das
 *	@since	1/9/23
 */
public class City implements Comparable<City> {
	
	// fields
	private String state;
	private String name;
	private int population;
    private String designation;
	// constructor
	
	public City(String sN, String cN, String ds, int pop)
	{
		name = cN;
		state = sN;
		population = pop;
        designation = ds;
	}
	
	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	 public int compareTo(City other)
	 {
		 if(this.population != other.population)
			return this.population - other.population;
		else if(this.state.equals(other.state))
			return this.state.compareTo(other.state) ;
		else 
			return this.name.compareTo( other.name);
		 
	 }
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	 public boolean equals(City other)
	 {
		 if(this.state == other.state)
		 {
			 if(this.name == other.name)
				return true;
		 }
		 return false;
	 }
	
	/**	Accessor methods */
	public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public String getType()
    {
        return designation;
    }
    public int getPopulation()
    {
        return population;
    }
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, designation,
						population);
	}
}
