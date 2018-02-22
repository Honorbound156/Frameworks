/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 */
public class Phenomenon {

	/**
	 * The name of the phenomenon
	 */
	String name;
	
	/**
	 * The Domain of the phenomenon
	 */
	Domain associatedDomain;
	
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
	public Phenomenon(String nameToSet, Domain domain){
		this.name = nameToSet;	
		this.associatedDomain = domain;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nameToSet) {
		this.name = nameToSet;
	}
	
}
