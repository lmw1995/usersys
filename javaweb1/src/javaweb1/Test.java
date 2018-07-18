package javaweb1;

public class Test {

	public static void main(String[] args) {
		Student stu = new Student("小明同学","男");
		Student stu1 = new Student("张飞","男");
		Teacher tea = new Teacher("张三老师","男");
		Study sdy = new Study();
		Tour to = new Tour();
		Teach te = new Teach();
        Address addr1 = new Address();
        Address addr2 = new Address();
        Address addr3 = new Address();
        	addr1.setName("湛江");
        	addr2.setName("广州");
        	addr3.setName("云南");
        	stu.dosomething(sdy, addr1);
            tea.dosomething(te, addr2);
            stu1.dosomething(to, addr3);
       	
}
}
