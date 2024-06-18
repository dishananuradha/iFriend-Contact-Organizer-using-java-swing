class DBConnection {
	private static DBConnection dbconnection;
	private ContactList contactList;

	private DBConnection() {
		contactList = new ContactList();
	}

	public static DBConnection getInstance() {
		if (dbconnection == null) {
			dbconnection = new DBConnection();
		}
		return dbconnection;
	}

	public ContactList getContactList() {
		return contactList;
	}
}