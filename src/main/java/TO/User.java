package TO;

public class User {
	
	
	    public User(String avatar, String name, int age, String job, String gender, String country) {
			
			this.avatar = avatar;
			this.name = name;
			this.age = age;
			this.job = job;
			this.gender = gender;
			this.country = country;
	    }
		
		private String avatar;
	    private String name;
	    private int age;
	    private String job;
	    private String gender;
	    private String country;
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
	
}
