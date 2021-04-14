package a12;

import java.util.Random;
// MODIFIED BY RILIND ASLLANI CS1410 
// U0931571
public class Carnivors extends Lifeform {

	/***
	 * Make a herbivore at an x,y pixel location
	 * @param _x
	 * @param _y
	 */
	public Carnivors(double _x, double _y) {
//		public Lifeform(double x, double y, double _foodValue, double _lifeSpan, 
//				double _reproductionRate, double _metabolizeRate, double _moveSpeed) {
		super(_x, _y, 50.0, 300.0, 0.02, 1.0, 5.0);
		// TODO Auto-generated constructor stub
		super.loadSprite("images/carnivor.png");
	}
	
	/***
	 * Make a child of Carnivor type
	 */
	@Override
	public Lifeform makeChild() {
		Carnivors h =  new Carnivors(this.getLocationX(), this.getLocationY());
		return h;
	}

	/***
	 * A Carnivor eats Herbivores.
	 */
	@Override
	public boolean canEat(Lifeform prey) {
		if (prey instanceof Herbivore)
			return true;
		// TODO Auto-generated method stub
		return false;
	}
	
	/***
	 * A Carnivor reproduces if it has enough energy and 
	 * has luck.
	 */
	@Override
	public void tryToReproduce(World world) {
		Random rng = new Random();
		if (this.getFoodValue() > 80 && rng.nextDouble() < this.getReproductionRate()) {
			Lifeform l = makeChild();
			world.addToPopulation(l);
			l.useCalories(40);
		}
	}
	
	/***
	 * Some creatures don't hunt, so return that status for efficiency
	 * @return
	 */
	public boolean isHunter() {
		return true;
	}
}

