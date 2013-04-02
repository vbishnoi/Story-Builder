
public class dog {
	
	int hieght;
	String name;
	int wieght;
	
	private void setName(String s){
		name = s;
	}
	
	private void setWieght(int w){
		wieght = w;
	}
	
	private void setHieght(int h){
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
