public class Main {

	public static void main(String[] args) {

		Name criaName = name -> middleName -> lastName -> () -> System.out.println(name + middleName + lastName);
		criaName.name("Thiago").middleName(" Rodrigues").lastName(" Assis").printName();

	}

}

interface Name {

	public MiddleName name(String name);
	
}


interface MiddleName {

	public LastName middleName(String middleName);
	
}

interface LastName {

	public PrintName lastName(String lastName);
	
}

interface PrintName {

	public void printName();
}