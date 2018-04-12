import java.util.ArrayList;

/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 * RequirementReference between two domains, related to a shared phenomenon.
 */
public class RequirementReference {

	//The domains connected by this RequirementReference
	Requirement requirement;
	Domain domain;
	
	//The phenomena that represent this RequirementReference
	ArrayList<Phenomenon> associatedPhenomena;
	
	//A description of the RequirementReference
	String description;
	
	public RequirementReference(){
		
	}
	
	public RequirementReference(Domain leftDomain, Domain rightDomain, ArrayList<Phenomenon> assocPhenomena, String descriptionGiven){
		this.domain = rightDomain;
		this.associatedPhenomena = assocPhenomena;
		this.description = descriptionGiven;
	}

	public Requirement getRequirement() {
		return this.requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Domain getdomain() {
		return domain;
	}

	public void setdomain(Domain domain) {
		this.domain = domain;
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

