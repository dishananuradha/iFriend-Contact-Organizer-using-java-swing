import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

class ContactController {
    public static int idCount = 0;
    public static ContactList contactList = DBConnection.getInstance().getContactList();

    //-------------------add contact----------------------//
    public static void addContact(Contact contact) {
        contactList.add(contact);
    }        

    //-------------------check validity of the name----------------------//
    public static boolean isValidName(String name) {
		return name.length() != 0; 
    }

    //-------------------check validity of the phone number----------------------//
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !phoneNumber.isEmpty() && Pattern.matches("0\\d{9}", phoneNumber);
    }

    //-------------------check validity of company name----------------------//
    public static boolean isValidCompanyName(String companyName) {
		return companyName.length() != 0; 
    }
    
    //-------------------check validity of salary----------------------//
    public static boolean isValidSalary(double salary) {
		return salary >= 0; 
    }
    
    //-------------------check validity of birthday----------------------//
    public static boolean isValidBirthDay(String birthDay) {
        try {
            LocalDate date = LocalDate.parse(birthDay);
            LocalDate currentDate = LocalDate.now();
            
            if (date.isAfter(currentDate)) {
                return false; //Birth date is in the future
            }
            return true; //Date is valid
            
        } catch (DateTimeParseException e) {
            return false;   //Invalid date format
        }
    }

    //-------------------is duplicate phone number----------------------//
    public static boolean isDuplicate(String phoneNumber) {
        return contactList.isDuplicate(phoneNumber);
    }

    //-------------------generate contact ids----------------------//
	public static String generateContactId() {
        idCount++;
        String contactId = String.format("C%04d", idCount);
        return contactId;
    }
}