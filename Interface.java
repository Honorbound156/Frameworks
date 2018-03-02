import java.util.ArrayList;

/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 * Interface between two domains, related to a shared phenomenon.
 */
public class Interface {

	//The domains connected by this interface
	Domain domainOne;
	Domain domainTwo;
	
	//The phenomena that represent this interface
	ArrayList<Phenomenon> associatedPhenomena;
	
	//A description of the interface
	String description;
	
	public Interface(){
		
	}
	
	public Interface(Domain leftDomain, Domain rightDomain, ArrayList<Phenomenon> assocPhenomena, String descriptionGiven){
		this.domainTwo = rightDomain;
		this.associatedPhenomena = assocPhenomena;
		this.description = descriptionGiven;
	}

	public Domain getDomainOne() {
		return domainOne;
	}

	public void setDomainOne(Domain domainOne) {
		this.domainOne = domainOne;
	}

	public Domain getDomainTwo() {
		return domainTwo;
	}

	public void setDomainTwo(Domain domainTwo) {
		this.domainTwo = domainTwo;
	}

	public ArrayList<Phenomenon> getAssociatedPhenomena() {
		return associatedPhenomena;
	}

	public void setAssociatedPhenomena(ArrayList<Phenomenon> associatedPhenomena) {
		this.associatedPhenomena = associatedPhenomena;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
