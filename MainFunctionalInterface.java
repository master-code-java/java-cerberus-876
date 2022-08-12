import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainFunctionalInterface {

	public static void main(String[] args) {
		
		
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		};
		
		consumer.accept("Thiago");
		
		
		Supplier<String> supplier = () -> null;
		System.out.println(supplier.get());
		
		Predicate<String> predicate = (String t) -> t == null;
		System.out.println(predicate.test("Thiago"));
		
		Function<String, Boolean> function = (String t) -> "Thiago".equals(t);
		System.out.println(function.apply("Teste"));
		
		BiFunction<Integer, Integer, Integer> biFunction = (Integer t, Integer u) -> t+u;
		System.out.println(biFunction.apply(1, 2));
	}
	
}
