package datas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ExercicioPraticoResolvido {

	public static void main(String[] args) {

		Statement2 statement1 = new Statement2("Mall – Explosion Ice cream", 25.0, "2022-07-23");
		Statement2 statement2 = new Statement2("Mall – Explosion Ice cream", 10.50, "2022-03-01");
		Statement2 statement3 = new Statement2("Mall – Explosion Ice cream", 15.0, "2022-03-01");
		Statement2 statement4 = new Statement2("Super Market – All things", 15.0, "2021-10-30");
		Statement2 statement5 = new Statement2("Amazon on-line", 50.0, "2022-05-01");
		Statement2 statement6 = new Statement2("Free fire gift card", 500.0, "2022-06-10");

		List<Statement2> statements = new ArrayList<>();
		statements.add(statement1);
		statements.add(statement2);
		statements.add(statement3);
		statements.add(statement4);
		statements.add(statement5);
		statements.add(statement6);

		System.out.println("given_listOfStatements_then_return_statements_with_less_than_ninety_days");
		given_listOfStatements_then_return_statements_with_less_than_ninety_days(statements);

		System.out.println("\ngiven_listOfStatements_then_return_statements_with_less_45_days");
		given_listOfStatements_then_return_statements_with_less_45_days(statements);

		System.out.println("\ngiven_listOfStatements_when_date_are_less_than_ninety_days_then_return_statements");
		given_listOfStatements_when_period_are_less_than_ninety_days_then_return_statements(statements);

		System.out.println("\ngiven_listOfStatements_when_period_are_grether_than_ninety_days_then_throw_exception");
		given_listOfStatements_when_period_are_grether_than_ninety_days_then_throw_exception(statements);
		
		System.out.println("\ngiven_listOfStatements_when_the_month_is_5_then_return_the_statements");
		given_listOfStatements_when_the_month_is_5_then_return_the_statements(statements);
		
		System.out.println("\ngiven_listOfStatements_when_the_year_is_2021_then_return_the_statements");
		given_listOfStatements_when_the_year_is_2021_then_return_the_statements(statements);

	}
	
	/**
	 * Métodod responsável por filtrar os lançamentos com menos de 90 dias.
	 * @param statements
	 * @return List<Statement2>
	 */
	public static List<Statement2> lessThanNinetyDays(List<Statement2> statements) {

		List<Statement2> filteredStatements = new ArrayList<>();

		LocalDateTime ninetyDaysBehind = LocalDateTime.now().minus(90L, ChronoUnit.DAYS);

		for (Statement2 st : statements) {
			if (st.getDate().isAfter(ninetyDaysBehind)) {
				filteredStatements.add(st);
			}
		}

		return filteredStatements;

	}

	/**
	 * Métodod responsável por filtrar os lançamentos com menos de 45 dias.
	 * @param statements
	 * @return List<Statement2>
	 */
	public static List<Statement2> lessThanFourtyFiveDays(List<Statement2> statements) {

		List<Statement2> filteredStatements = new ArrayList<>();

		LocalDateTime ninetyDaysBehind = LocalDateTime.now().minus(45L, ChronoUnit.DAYS);

		for (Statement2 st : statements) {
			if (st.getDate().isAfter(ninetyDaysBehind)) {
				filteredStatements.add(st);
			}
		}

		return filteredStatements;
	}
	
	
	/**
	 * Métodod responsável por filtrar os lançamentos entre um período menor que 90 dias.
	 * @param statements
	 * @return List<Statement2>
	 */
	public static List<Statement2> betweenDays(List<Statement2> statements, LocalDateTime from, LocalDateTime to)
			throws Exception {

		if (Duration.between(from, to).toDays() > 90l) {
			throw new Exception("The period must be less than ninety days");

		} else {
			List<Statement2> filteredStatements = new ArrayList<>();

			for (Statement2 st : statements) {
				if (st.getDate().isAfter(from) && st.getDate().isBefore(to)) {
					filteredStatements.add(st);
				}
			}

			return filteredStatements;
		}
	}
	
	/**
	 * Métodod responsável por filtrar os lançamentos do mês.
	 * @param statements
	 * @return List<Statement2>
	 */
	public static List<Statement2> inTheMonth(List<Statement2> statements, Month month){
		
		List<Statement2> filteredStatements = new ArrayList<>();

		for(Statement2 st : statements) {
			if(st.getDate().getMonth().equals(month)) {
				filteredStatements.add(st);
				
			}
		}
		
		return filteredStatements;
		
		
	}
	
	/**
	 * Métodod responsável por filtrar os lançamentos do ano.
	 * @param statements
	 * @return List<Statement2>
	 */
	public static List<Statement2> inTheYear(List<Statement2> statements, int year){

		List<Statement2> filteredStatements = new ArrayList<>();

		for(Statement2 st : statements) {
			if(st.getDate().getYear() == year) {
				filteredStatements.add(st);
			}
		}
		
		return filteredStatements;
	}
	
	/**
	 * Este método representa um teste unitário que valida o comportamento do método inTheYear.
	 * @param statements
	 */
	private static void given_listOfStatements_when_the_year_is_2021_then_return_the_statements(
			List<Statement2> statements) {
		
		List<Statement2> result = inTheYear(statements, 2021);
		List<Statement2> expected = new ArrayList<>();
		expected.add(new Statement2("Super Market – All things", 15.0, "2021-10-30"));

		msgPrint(result, expected);
		
	}

	/**
	 * Este método representa um teste unitário que valida o comportamento do método inTheMonth.
	 * @param statements
	 */
	private static void given_listOfStatements_when_the_month_is_5_then_return_the_statements(
			List<Statement2> statements) {
		
		List<Statement2> result = inTheMonth(statements, Month.MAY);
		List<Statement2> expected = new ArrayList<>();
		expected.add(new Statement2("Amazon on-line", 50.0, "2022-05-01"));

		msgPrint(result, expected);
		
	}
	
	
	/**
	 * Este método representa um teste unitário que valida o comportamento do método betweenDays com um periodo maior que noventa dias.
	 * @param statements
	 */
	private static void given_listOfStatements_when_period_are_grether_than_ninety_days_then_throw_exception(
			List<Statement2> statements) {
		try {
			LocalDateTime from = LocalDateTime.now().minus(95l, ChronoUnit.DAYS);
			LocalDateTime to = LocalDateTime.now();

			betweenDays(statements, from, to);
			System.out.println("TEST FAILED!");
			
		} catch (Exception e) {
			System.out.println("An error occured: " + e.getMessage());
			System.out.println("TESTE PASSED!");
		}
	}

	
	/**
	 * Este método representa um teste unitário que valida o comportamento do método betweenDays com um periodo menor que noventa dias.
	 * @param statements
	 */
	private static void given_listOfStatements_when_period_are_less_than_ninety_days_then_return_statements(
			List<Statement2> statements) {

		LocalDateTime from = LocalDateTime.now().minus(5l, ChronoUnit.DAYS);
		LocalDateTime to = LocalDateTime.now();

		try {

			List<Statement2> result = betweenDays(statements, from, to);
			List<Statement2> expected = new ArrayList<>();
			expected.add(new Statement2("Mall – Explosion Ice cream", 25.0, "2022-07-23"));

			msgPrint(result, expected);

		} catch (Exception e) {
			System.out.println("An error occured. msg:" + e.getMessage() + "parameters: " + from + "to: " + to);
			System.out.print("TEST FAILED!");
		}
	}

	/**
	 * Este método representa um teste unitário que valida o comportamento do método lessThanFourtyFiveDays.
	 * @param statements
	 */
	private static void given_listOfStatements_then_return_statements_with_less_45_days(List<Statement2> statements) {
		List<Statement2> result = lessThanFourtyFiveDays(statements);
		List<Statement2> expected = new ArrayList<>();
		expected.add(new Statement2("Mall – Explosion Ice cream", 25.0, "2022-07-23"));
		expected.add(new Statement2("Free fire gift card", 500.0, "2022-06-10"));

		msgPrint(result, expected);
	}

	/**
	 * Este método representa um teste unitário que valida o comportamento do método lessThanNinetyDays.
	 * @param statements
	 */
	private static void given_listOfStatements_then_return_statements_with_less_than_ninety_days(
			List<Statement2> statements) {
		List<Statement2> result = lessThanNinetyDays(statements);

		List<Statement2> expected = new ArrayList<>();
		expected.add(new Statement2("Mall – Explosion Ice cream", 25.0, "2022-07-23"));
		expected.add(new Statement2("Amazon on-line", 50.0, "2022-05-01"));
		expected.add(new Statement2("Free fire gift card", 500.0, "2022-06-10"));

		msgPrint(result, expected);
	}

	/**
	 * Este método é usado dentro dos teste unitários para exibir uma mensagem de sucesso ou de fallha, caso o resultado não seja igual ao esperado.
	 * @param result
	 * @param expected
	 */
	private static void msgPrint(List<Statement2> result, List<Statement2> expected) {
		if (result.equals(expected)) {
			System.out.println("TEST PASSED!");
		} else {
			System.out.println("TEST FAILED!");
		}
	}

}



/**
 * 
 * @author Thiago
 *
 * Esta classe é a representação de um lançamento no extrato do cliente.
 * 
 * É importante que essa classe tenha os métodos equals e hashcode para que na comparação do 
 * resultado com o esperado functione corretamente.
 * 
 *
 */
class Statement2 {

	private String name;
	private double value;
	private LocalDateTime date;

	public Statement2(String name, double value, String date) {
		this.name = name;
		this.value = value;
		this.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
	}

	public Statement2(String name, double value, LocalDateTime date) {
		this.name = name;
		this.value = value;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement2 other = (Statement2) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statement [name=" + name + ", value=" + value + ", date=" + date + "]";
	}
}