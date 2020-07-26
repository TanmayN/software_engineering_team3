import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsersStore implements Serializable{

	// list of users saved in the system
	private List<User> users;
	
	public UsersStore() {
		users = new ArrayList<User>();
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	// reads from the passed file and return the  store object with loaded list 
	// of registested users.
	public void loadFromFile(String fileName) {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		UsersStore store = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			if (ois == null) {
				System.out.println("ois is null");
			}
			
			users = (List<User>)(ois.readObject());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// saves the store object along with the list of users to 
	// the file with the provided file name.
	public void saveToFile(String fileName) {
		FileOutputStream fos = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fos = new FileOutputStream(fileName);
			objectOutputStream = new ObjectOutputStream(fos);
			
			objectOutputStream.writeObject(users);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void print() {
		for (User u : users) {
			System.out.println(u);
		}
	}
	
}
