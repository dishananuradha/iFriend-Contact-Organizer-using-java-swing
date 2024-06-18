class Contact{
	private String contactId;
	private String name;
	private String phoneNumber;
	private String companyName;
	private double salary;
	private String birthDay;
	
	public void setContactId(String contactId){
		this.contactId = contactId;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setBirthDay(String birthDay){
		this.birthDay = birthDay;
	}
	
	public String getContactId(){
		return contactId;
	}
	public String getName(){
		return name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getCompanyName(){
		return companyName;
	}
	public double getSalary(){
		return salary;
	}
	public String getBirthDay(){
		return birthDay;
	}
}