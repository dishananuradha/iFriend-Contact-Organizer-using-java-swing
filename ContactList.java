class ContactList{
	private Node start;
	
	//-------------------add element----------------------//
	public void add(Contact contact){
		Node n1 = new Node(contact);
		Node lastNode = start;
		if(start == null){
			start = n1;
		}else{
			while(lastNode.getNext() != null){
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(n1);
		}
	}

	//-------------------search name or phone number existance----------------------//
    public int search(String query){
		Node temp = start;
		int indexCount = 0;
		while(temp != null){
			if(temp.getContact().getName().equals(query) || temp.getContact().getPhoneNumber().equals(query)){
				return indexCount;
			}
			indexCount++;
			temp = temp.getNext();
		}
		return -1;
	}
	
	//-------------------delete element----------------------//
    public void delete(String query) {
		int index = search(query);
		if(index == 0){
			start=start.getNext();
		}else{
			int indexCount = 0;
			Node temp = start;
			while(indexCount < index-1){
				indexCount++;
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
    }
    
    //-------------------search phone number duplicate or not----------------------//
    public boolean isDuplicate(String phoneNumber){
		Node temp = start;
		while(temp != null){
			if(temp.getContact().getPhoneNumber().equals(phoneNumber)){
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}
	
	//-------------get contact using query---------------//
	public Contact get(String query){
		int index = search(query);
		Node temp = start;
		int indexCount = 0;
		while(indexCount < index){
			indexCount++;
			temp = temp.getNext();
		}
		return temp.getContact();  
	}
	
	//-------------get how many nodes are there---------------//
	public int size(){
		int indexCount = 0;
		Node temp = start;
		while(temp != null){
			indexCount++;
			temp = temp.getNext();
		}
		return indexCount;
	}

	//---------------insert contacts to an array--------------//
	private Contact[] toArray(){
		Contact[] tempArray = new Contact[size()];
		Node temp = start;
		for (int i = 0; i < tempArray.length; i++){
			tempArray[i] = temp.getContact();
			temp = temp.getNext();
		}
		return tempArray;
	}
    
    //-------------------sort by name----------------------//
    public void sortByName(String str){
		Contact[] contactArray = toArray();
        for(int i = 0; i < contactArray.length - 1; i++) {
            for(int j = 0; j < contactArray.length - 1 - i; j++){
                if(contactArray[j].getName().compareTo(contactArray[j+1].getName()) > 0){       //compares two strings lexicographically

                    Contact temp = contactArray[j];
                    contactArray[j] = contactArray[j+1];
                    contactArray[j+1] = temp;
                }
            }
        }
        printTable(str, contactArray);
    }
    
    //------------------sort by salary----------------------//
    public void sortBySalary(String str){
		Contact[] contactArray = toArray();
        for(int i = 0; i < contactArray.length - 1; i++) {
            for(int j = 0; j < contactArray.length - 1 - i; j++){
                if(contactArray[j].getSalary() > contactArray[j+1].getSalary()){           //compare salary numerically

					Contact temp = contactArray[j];
                    contactArray[j] = contactArray[j+1];
                    contactArray[j+1] = temp;
                }
            }
        }
        printTable(str, contactArray);
    }

	//-----------------sort by birthday----------------------//
    public void sortByBirthday(String str){
		Contact[] contactArray = toArray();
        for(int i = 0; i < contactArray.length - 1; i++) {
            for(int j = 0; j < contactArray.length - 1 - i; j++){
                if(contactArray[j].getBirthDay().compareTo(contactArray[j+1].getBirthDay()) > 0){        //comparing the dates chronologically.

					Contact temp = contactArray[j];
                    contactArray[j] = contactArray[j+1];
                    contactArray[j+1] = temp;
                }
            }
        }
        printTable(str, contactArray);
    }
    
	//----------------print contact info-------------------//
    public void printContactInfo(String query){
		Contact contact = get(query);
		
		System.out.printf("\n\n\tContact ID\t\t: %s", contact.getContactId());
		System.out.printf("\n\tName\t\t\t: %s", contact.getName());
		System.out.printf("\n\tPhone Number\t\t: %s", contact.getPhoneNumber());
		System.out.printf("\n\tCompany Name\t\t: %s", contact.getCompanyName());
		System.out.printf("\n\tSalary\t\t\t: %s", contact.getSalary());
		System.out.printf("\n\tB'Day(YYYY-MM-DD)\t: %s", contact.getBirthDay());
	}
	
	//----------------print contacts table-------------------//
	private void printTable(String str, Contact[] contactArray){
		System.out.println("                  +-------------------------------------------------------------+");
		System.out.printf("                  |\t\t\tList contact by %s\t\t\t|\n", str);
		System.out.println("                  +-------------------------------------------------------------+");
		System.out.println();
		System.out.println(" +-----------------------------------------------------------------------------------------------+");
		System.out.println(" | Contact ID  |     Name     |  Phone Number  |    Company    |     Salary     |    Birthday    |");
		System.out.println(" +-----------------------------------------------------------------------------------------------+");

		for(int i = 0; i < contactArray.length; i++){
			System.out.printf(" | %-12s| %-13s|   %-13s|  %-13s|%,13.2f   |  %-14s|\n", contactArray[i].getContactId(), contactArray[i].getName(), contactArray[i].getPhoneNumber(), contactArray[i].getCompanyName(), contactArray[i].getSalary(), contactArray[i].getBirthDay());	
		}
		System.out.println(" +-----------------------------------------------------------------------------------------------+");
	}
}