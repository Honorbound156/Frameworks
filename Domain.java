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
	
	//Name of the domain.
	String name;
	
	/*This holds all associated Interfaces. 
	 *Associated Domains can be determined by examining the other ends of these interfaces.
	 */
	ArrayList<Interface> associatedInterfaces;
	
	//This will hold both the state and event phenomena that the domain owns.
	ArrayList<Phenomenon> associatedPhenomena;
	
	//These phenomena are those shared with this domain, owned by another domain.
	//TODO These will need to be updated based on associated domains.
	ArrayList<Phenomenon> sharedPhenomena;
	
	/*
	 * Default Constructor
	 */
	public Domain(){
		
	}
	
	/*
	 * Constructor that specifies the name of the domain
	 */
	public Domain(String nameOfDomain){
		this.name = nameOfDomain;
		this.associatedInterfaces = new ArrayList<Interfaces>();
		this.associatedPhenomena = new ArrayList<Phenomenon>();
		this.sharedPhenomena = new ArrayList<Phenomenon>();
	}

	/**
	 * Allow for the manual addition of a new phenomenon to a domain
	 * @param phenomenon, the phenomenon to add to the domain
	 */
	public void addPhenomenon(Phenomenon phenomenon){
		this.associatedPhenomena.add(phenomenon);
	}
	
	/**
	 * Allow for the manual removal of a phenomenon from a domain
	 * @param phenomenonToRemove, the phenomenon to remove from the domain
	 */
	public void removePhenomenon(int phenomenonToRemove){
		//TODO Improve mechanism for removing the desired phenomenon
		this.associatedPhenomena.remove(phenomenonToRemove);
	}
	
	/**
	 * Allow for the manual addition of a new phenomenon to a domain
	 * @param phenomenon, the phenomenon to add to the domain
	 */
	public void addSharedPhenomenon(Phenomenon phenomenon){
		this.sharedPhenomena.add(phenomenon);
	}
	
	/**
	 * Allow for the manual removal of a phenomenon from a domain
	 * @param phenomenonToRemove, the phenomenon to remove from the domain
	 */
	public void removeSharedPhenomenon(int phenomenonToRemove){
		//TODO Improve mechanism for removing the desired phenomenon
		this.sharedPhenomena.remove(phenomenonToRemove);
	}
	
	/**
	 * Allow for the manual addition of a new interface to a domain
	 * @param interface, the interface to add to the domain
	 */
	public void addInterface(Interface interface){
		this.associatedInterfaces.add(interface);
	}
	
	/**
	 * Allow for the manual removal of an interface from a domain
	 * @param interfaceToRemove, the interface to remove from the domain
	 */
	public void removeInterface(int interfaceToRemove){
		//TODO Improve mechanism for removing the desired interface
		this.associatedPhenomena.remove(interfaceToRemove);
	}
	
	/**
	 * This method recreates the individual list of State Phenomena from
	 * the overall associated phenomena list.
	 */
	public ArrayList<StatePhenomenon> getStatePhenomena(){
		
		ArrayList<StatePhenomena> statePhenomenonList = new ArrayList<StatePhenomena>();
		
		for(Phenomenon phenomenon : associatedPhenomena){
			if("StatePhenomenon".equals(phenomenon.getClass().getName())){
				statePhenomenonList.add((StatePhenomenon)phenomenon);
			}
		}
		
		return statePhenomenonList;
	}
	
	/**
	 * This method recreates the individual list of Event Phenomena from
	 * the overall associated phenomena list.
	 */
	public ArrayList<EventPhenomenon> getEventPhenomena(){
		
		ArrayList<EventPhenomena> eventPhenomenonList = new ArrayList<EventPhenomena>();
		
		for(Phenomenon phenomenon : associatedPhenomena){
			if("EventPhenomenon".equals(phenomenon.getClass().getName())){
				eventPhenomenonList.add((EventPhenomenon)phenomenon);
			}
		}
		
		return eventPhenomenonList;
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
