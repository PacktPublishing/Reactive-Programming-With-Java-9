import java.util.function.Function;

public class ShowLength_new {
	
	// function will accept integer and return string
	public void show(int length, Function<Integer, String>converter) {
		System.out.println(" the length is " + converter.apply((length)));
	}

	public static void main(String[] args) {
		ShowLength_new length_new = new ShowLength_new();
		LengthConverter converter = new LengthConverter();
		length_new.show(100, converter::toMeter);
	}


}
