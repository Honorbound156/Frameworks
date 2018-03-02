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
	
	//Name of the phenomena
	String name;
	
	//Description of the domain
	String description;
	
	/*This holds all associated Interfaces. 
	 *Associated Domains can be determined by examining the other ends of these interfaces.
	 */
	ArrayList<Interface> associatedInterfaces;
	
	//This will hold both state and event phenomena owned by this domain
	ArrayList<Phenomenon> associatedPhenomena;
	
	//These phenomena are shared with other domains
	//TODO These will need to be updated based on associated domains.
	ArrayList<Phenomenon> sharedPhenomena;
	
	/*
	 * Default Constructor
	 */
	public Domain(){
		
	}

	/*
	 * Constructor that specifies size of phenomena list and name of domain
	 * @param int phenomenaCount, the number of associate phenomena of the Domain  
	 */
	public Domain(String nameOfDomain){
		this.associatedPhenomena = new ArrayList<Phenomenon>();
		this.name = nameOfDomain;
	}

	/**
	 * Allow for the manual addition of a new owned phenomenon to a domain
	 * @param phenomenon, the phenomenon to add to the domain
	 */
	public void addPhenomenon(Phenomenon phenomenon){
		this.associatedPhenomena.add(phenomenon);
	}
	
	/**
	 * Allow for the manual removal of an owned phenomenon from a domain
	 * @param phenomenonToRemove
	 */
	public void removePhenomenon(int phenomenonToRemove){
		//TODO Improve mechanism for removing the desired phenomenon
		this.associatedPhenomena.remove(phenomenonToRemove);
	}
	
	/**
	 * Allow for the manual addition of a new shared phenomenon to a domain
	 * @param phenomenon, the phenomenon to add to the domain
	 */
	public void addSharedPhenomenon(Phenomenon phenomenon){
		this.sharedPhenomena.add(phenomenon);
	}
	
	/**
	 * Allow for the manual removal of a shared phenomenon from a domain
	 * @param phenomenonToRemove
	 */
	public void removeSharedPhenomenon(int phenomenonToRemove){
		//TODO Improve mechanism for removing the desired phenomenon
		this.sharedPhenomena.remove(phenomenonToRemove);
	}
	
	/**
	 * Allow for the manual addition of a new Interface to a domain
	 * @param Interface, the Interface to add to the domain
	 */
	public void addInterface(Interface interfaceToAdd){
		this.associatedInterfaces.add(interfaceToAdd);
	}
	
	/**
	 * Allow for the manual removal of an Interface from a domain
	 * @param InterfaceToRemove
	 */
	public void removeInterface(int InterfaceToRemove){
		//TODO Improve mechanism for removing the desired Interface
		this.associatedInterfaces.remove(InterfaceToRemove);
	}
	
	/**
	 * Utility method to get the state phenomena of the domain.
	 * @return ArrayList<StatePhenomenon>
	 */
	public ArrayList<StatePhenomenon> getStatePhenomena(){
		ArrayList<StatePhenomenon> statePhenomena = new ArrayList<StatePhenomenon>();
		for(Phenomenon phenomenon : this.associatedPhenomena){
			if("StatePhenomenon".equals(phenomenon.getClass().toString())){
				statePhenomena.add((StatePhenomenon)phenomenon);
			}
		}	
		
		return statePhenomena;
	}

	/**
	 * Utility method to get the event phenomena of the domain.
	 * @return ArrayList<EventPhenomenon>
	 */
	public ArrayList<EventPhenomenon> getEventPhenomena(){
		ArrayList<EventPhenomenon> eventPhenomena = new ArrayList<EventPhenomenon>();
		for(Phenomenon phenomenon : this.associatedPhenomena){
			if("EventPhenomenon".equals(phenomenon.getClass().toString())){
				eventPhenomena.add((EventPhenomenon)phenomenon);
			}
		}	
		
		return eventPhenomena;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Phenomenon> getPhenomena() {
		return this.associatedPhenomena;
	}

	public void setPhenomena(ArrayList<Phenomenon> phenomena) {
		this.associatedPhenomena = phenomena;
	}
	
	public ArrayList<Phenomenon> getSharedPhenomena() {
		return sharedPhenomena;
	}

	public void setSharedPhenomena(ArrayList<Phenomenon> sharedPhenomena) {
		this.sharedPhenomena = sharedPhenomena;
	}

	public ArrayList<Interface> getAssociatedInterfaces() {
		return associatedInterfaces;
	}

	public void setAssociatedInterfaces(ArrayList<Interface> associatedInterfaces) {
		this.associatedInterfaces = associatedInterfaces;
	}

}
