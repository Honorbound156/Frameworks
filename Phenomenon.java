/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 */
public class Phenomenon {

	
	//The name of the phenomenon
	String name;
	
	//The Domain of the phenomenon 
	Domain associatedDomain;
	
	//A description of the phenomenon
	String description;
	
	/**
	 * Default Constructor
	 */
	public Phenomenon(){
	}
	
	/**
	 * Constructor to set the type of phenomenon, event or state
	 * and the associated domain.
	 * @param nameToSet, the name of the phenomenon
	 * @param domain, the domain that the phenomena is associated with
	 */
	public Phenomenon(String nameToSet, Domain domain, String descriptionGiven){
		this.name = nameToSet;	
		this.associatedDomain = domain;
		this.description = descriptionGiven;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nameToSet) {
		this.name = nameToSet;
	}

	public Domain getAssociatedDomain() {
		return associatedDomain;
	}

	public void setAssociatedDomain(Domain associatedDomain) {
		this.associatedDomain = associatedDomain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
