public class MainNameMaker {

	public static void main(String[] args) {

		Name name = new Name() {

			@Override
			public MiddleName name(NameMaker<String> name) {
				return new MiddleName() {

					@Override
					public LastName middleName(NameMaker<String> middleName) {
						return new LastName() {

							@Override
							public PrintName lastName(NameMaker<String> lastName) {
								return new PrintName() {

									@Override
									public void printName() {
										System.out.println(name.getValue() + middleName.getValue() + lastName.getValue());

									}
								};
							}
						};
					}
				};
			}

		};
		
		name.name(() -> {
			
		// vai ao webservice
			// procura pelo Usuário Thiago
				// Pega o nome do usuário
					// Pega somente o primeiro nome do usuário
						// retorno o primeiro nome do usuário
		return "Thiago";
		
		})
		.middleName(() -> "Thiago")
		.lastName(() ->" de souza")
		.printName();



	}

}

@FunctionalInterface
interface NameMaker<T> {
	T getValue();
}

@FunctionalInterface
interface Name {

	String propertie = "";

	public MiddleName name(NameMaker<String> nameMaker);
	boolean equals(Object obj);
	public String toString();

	default String getPOssibleValues() {
		return null;
	}

	public static int getValues() {
		return 0;
	}

}

interface MiddleName {

	public LastName middleName(NameMaker<String> middleName);

}

interface LastName {

	public PrintName lastName(NameMaker<String> lastName);

}

interface PrintName {

	public void printName();
}