import java.util.ArrayList;

/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 * An interacting domain in a problem frame
 */

public class Domain {
	
	/*This holds all associated Interfaces. 
	 *Associated Domains can be determined by examining the other ends of these interfaces.
	 */
	ArrayList<Interface> associatedInterfaces;
	
	//This will hold both state and event phenomena
	ArrayList<Phenomenon> associatedPhenomena;
	
	//These lists will filter the phenomena into two lists, event or state, as per documentation request
	ArrayList<StatePhenomenon> associatedStatePhenomena;
	ArrayList<EventPhenomenon> associatedEventPhenomena;
	
	//These phenomena are shared with other domains
	//TODO These will need to be updated based on associated domains.
	ArrayList<Phenomenon> sharedPhenomena;
	
	//Name of the phenomena
	String name;
	
	/*
	 * Default Constructor
	 */
	public Domain(){
		
	}
	
	/*
	 * Constructor that specifies size of phenomena list and name of domain
	 * @param int phenomenaCount, the number of associate phenomena of the Domain  
	 */
	public Domain(int phenomenaCount, String nameOfDomain){
		this.associatedPhenomena = new ArrayList<Phenomenon>(phenomenaCount);
		this.name = nameOfDomain;
	}

	/**
	 * allow for the manual addition of a new phenomenon to a domain
	 * @param phenomenon, the phenomenon to add to the domain
	 */
	public void addPhenomenon(Phenomenon phenomenon){
		this.associatedPhenomena.add(phenomenon);
	}
	
	/**
	 * allow for the manual removal of a phenomenon from a domain
	 * @param phenomenonToRemove
	 */
	public void removePhenomenon(int phenomenonToRemove){
		//TODO Improve mechanism for removing the desired phenomenon
		this.associatedPhenomena.remove(phenomenonToRemove);
	}
	
	/**
	 * This method recreates the individual lists of state and event phenomena from 
	 * the overall associated phenomena list.
	 */
	public void segregatePhenomena(){
		for(Phenomenon phenomenon : associatedPhenomena){
			if("StatePhenomenon".equals(phenomenon.getClass().getName())){
				associatedStatePhenomena.add((StatePhenomenon)phenomenon);
			} else {
				associatedEventPhenomena.add((EventPhenomenon)phenomenon);
			}
		}
	}
	
	public ArrayList<Phenomenon> getSharedPhenomena() {
		return sharedPhenomena;
	}

	public void setSharedPhenomena(ArrayList<Phenomenon> sharedPhenomena) {
		this.sharedPhenomena = sharedPhenomena;
	}

	public ArrayList<Phenomenon> getPhenomena() {
		return this.associatedPhenomena;
	}

	public void setPhenomena(ArrayList<Phenomenon> phenomena) {
		this.associatedPhenomena = phenomena;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
