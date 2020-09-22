package a5;

public class SushiImpl implements Sushi {

	private String name;
	private IngredientPortion[] ingredientType;

	public SushiImpl(String name, IngredientPortion[] ingredientType) {
		this.name = name;
		this.ingredientType = ingredientType;
	}
	
	public String getName() {
		return name;
	}

	 
	public IngredientPortion[] getIngredients() {
		return ingredientType;
	}

	 
	public int getCalories() {
		double x = 0;
		for (int i = 0; i < ingredientType.length; i++) {
			x += ingredientType[i].getCalories() * ingredientType[i].getAmount();
		}
		return (int) x;
	}


	public double getCost() {
		double total = 0;
		for (int i = 0; i < ingredientType.length; i++) {
			total += ingredientType[i].getCost() * ingredientType[i].getAmount();
		}
		
		return (double)Math.round(total * 100d) / 100d;
	}

	
	public boolean getHasRice() {
		for (int i = 0; i < ingredientType.length; i++) {
			if (!ingredientType[i].getIsRice()) {
				return false;
			}
		}
		return true;
	}

	
	public boolean getHasShellfish() {
		for (int i = 0; i < ingredientType.length; i++) {
			if (!ingredientType[i].getIsShellfish()) {
				return false;
			}
		}
		return true;
	}

	
	public boolean getIsVegetarian() {
		for (int i = 0; i < ingredientType.length; i++) {
			if (!ingredientType[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}

}
