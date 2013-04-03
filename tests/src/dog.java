
public class dog {
	
	int hieght;
	String name;
	int wieght;
	
	void setName(String s){
		name = s;
	}
	
	void setWieght(int w){
		wieght = w;
	}
	
	void setHieght(int h){
		hieght = h;
	}
	
	String getName(){
		return name;
	}
	int getHieght(){
		return hieght;
	}
	int getWieght(){
		return wieght;
	}
	
	void woof(){
		System.out.println(name + "woof woof ");
	}

}
