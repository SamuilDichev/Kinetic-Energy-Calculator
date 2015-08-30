public class Formulas {
	public double energy (double mass, double velocity) {
		double energy = (mass * velocity * velocity)/2;
		return energy;
	}

	public double work (double force, double displacement) {
		double work = force * displacement;
		return work;
	}
}