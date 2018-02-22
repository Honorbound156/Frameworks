import java.util.ArrayList;

/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 * Interface between two domains, related to set of shared phenomenon.
 */
public class Interface {

	Domain domainOne;
	Domain domainTwo;
	ArrayList<Phenomenon> associatedPhenomena;
	
	public Interface(){
		
	}
	
	public Interface(Domain leftDomain, Domain rightDomain, ArrayList<Phenomenon> assocPhenomena){
		this.domainOne = leftDomain;
		this.domainTwo = rightDomain;
		this.associatedPhenomena = assocPhenomena;
	}
	
}
