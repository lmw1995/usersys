package javaweb1;

public class Person {	
	   public String name;
       public String sex;
       public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
   public Person (String _name,String _sex){
   name=_name;
   sex=_sex;
   }
}
