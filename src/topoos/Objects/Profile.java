package topoos.Objects;

import java.util.Date;

public class Profile {

	private Date Birthday = null;
	private String Gender = null;

	/**
	 * 
	 * @param birthday
	 * @param gender
	 */
	public Profile(Date birthday, String gender) {
		super();
		Birthday = birthday;
		Gender = gender;
	}

	/**
	 * 
	 * @return Date of birthday
	 */
	public Date getBirthday() {
		return Birthday;
	}

	/**
	 * Set the birthday date
	 * 
	 * @param birthday
	 *            date of birthday to set
	 */
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	/**
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * 
	 * @param gender
	 *            gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}
}