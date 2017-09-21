
public class LengthConverter {

	public String toMeter(int length) {
		return length / 100.0 + " meter";
	}

	public String toKilometer(int length) {
		return length / 1000.0 + " kilometer";
	}

	public String convert(int length, int unit) {
		if (unit == 1) {
			return length / 100.0 + " meter";
		} else if (unit == 2) {
			return length / 1000.0 + " kilometer";
		}
		return length + " cm";
	}

}
