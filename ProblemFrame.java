import java.util.ArrayList;

/**
 * Project Frameworks
 * Graphical Problem Framing Software Solution
 * 
 * @author Hal M. Hattis
 * @CSDirectedStudy
 *
 * The over-arching component used in the Frameworks system,
 * composed of interacting domains, possessing phenomena, 
 * and connected via interfaces. 
 */
public class ProblemFrame {

	//unused list of phenomena. These will actually be within the domains, handled at a lower level.
	//ArrayList<Phenomenon> phenomena = new ArrayList<Phenomenon>();
	ArrayList<Domain> domains = new ArrayList<Domain>();
	ArrayList<Interface> interfaces = new ArrayList<Interface>();
	ArrayList<Requirement> requirements = new ArrayList<Requirement>();
	ArrayList<RequirementReference> requirementReferences = new ArrayList<RequirementReference>();

	String description;
	
	public ProblemFrame(){
		this.domains.add(new Domain("MachineDomain"));
	}
	
	public ProblemFrame(ArrayList<Domain> domainsIn, ArrayList<Interface> interfacesIn, String descriptionIn){
		this.domains = domainsIn;
		this.interfaces = interfacesIn;
		this.description = descriptionIn;
	}
	/**
	 * Search the phenomena lists of each domain and cross reference 
	 * for interface necessary phenomenon based relationships between domains
	 * Should be used to graphically represent the system.
	 * Should populate interfaces in the problem frame.
	 */
	public ArrayList<Interface> scanForRelations(){
		return interfaces;
		
		/**
		ArrayList<Interface> associationInterfaces = new ArrayList<Interface>();
		
		for(Domain leftDomain : this.domains){
			for(Domain rightDomain : this.domains){
				if(!leftDomain.equals(rightDomain)){
					//If the domains share a phenomena, create interface and return
					for(Phenomenon leftPhenomenon : leftDomain.associatedPhenomena){
						for(Phenomenon rightPhenomenon : rightDomain.associatedPhenomena){
							if(leftDomain.equals(rightPhenomenon)){
								Interface newInterface = new Interface(leftDomain, rightDomain, leftPhenomenon);
								associationInterfaces.add(newInterface);
							}
						}
					}
				}
			}
		}
		
		return associationInterfaces;
		*/
	}
	
	/**
	 * Add a domain to the problem frame
	 * TODO, consider running a "scanForRelations"
	 * @param domainToAdd
	 */
	public void addDomain(Domain domainToAdd){
		domains.add(domainToAdd);
	}
	
	/**
	 * Remove a domain from the problem frame.
	 * TODO, evaluate how this effects interfaces. 
	 * Perhaps if a domain is removed, scan interfaces to adjust problem frame
	 * @param domainToRemove, the domain being removed.
	 */
	public void removeDomain(int domainToRemove){
		domains.remove(domainToRemove);
	}
	
	/**
	 * Add a Requirement to the problem frame
	 * TODO, consider running a "scanForRelations"
	 * @param RequirementToAdd
	 */
	public void addRequirement(Requirement RequirementToAdd){
		requirements.add(RequirementToAdd);
	}
	
	/**
	 * Remove a Requirement from the problem frame.
	 * TODO, evaluate how this effects interfaces. 
	 * Perhaps if a Requirement is removed, scan interfaces to adjust problem frame
	 * @param RequirementToRemove, the Requirement being removed.
	 */
	public void removeRequirement(int RequirementToRemove){
		requirements.remove(RequirementToRemove);
	}
	
	/**
	 * 
	 * Remove the interface between two domains, implying that their 
	 * shared phenomena have been somehow impeded. Should throw warnings about disassociation of
	 * related phenomena between domains
	 */
	public void removeInterface(int indexOfInterfaceToRemove){
		this.interfaces.remove(indexOfInterfaceToRemove);
	}

	/**
	 * Add interface between two domains, implying a relationship of shared
	 * phenomena between the domains
	 */
	public void addInterface(Interface interfaceToAdd){
		this.interfaces.add(interfaceToAdd);
	}

	/**
	 * 
	 * Remove the RequirementReference between two domains, implying that their 
	 * shared phenomena have been somehow impeded. Should throw warnings about disassociation of
	 * related phenomena between domains
	 */
	public void removeRequirementReference(int indexOfRequirementReferenceToRemove){
		this.requirementReferences.remove(indexOfRequirementReferenceToRemove);
	}

	/**
	 * Add RequirementReference between two domains, implying a relationship of shared
	 * phenomena between the domains
	 */
	public void addRequirementReference(RequirementReference RequirementReferenceToAdd){
		this.requirementReferences.add(RequirementReferenceToAdd);
	}
	
	public ArrayList<Domain> getDomains() {
		return domains;
	}

	public void setDomains(ArrayList<Domain> domains) {
		this.domains = domains;
	}

	public ArrayList<Interface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(ArrayList<Interface> interfaces) {
		this.interfaces = interfaces;
	}
	
}
