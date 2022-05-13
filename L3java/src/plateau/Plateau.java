package plateau;

public class Plateau {
	
	private Case[][] cases;
	
	private static final int TAILLE_PLATEAU = 15;
	
	
	public Plateau() {
		this.cases = new Case[TAILLE_PLATEAU][TAILLE_PLATEAU];
		
		for(int i = 0; i < TAILLE_PLATEAU; i ++) {
			for(int j = 0; j < TAILLE_PLATEAU; j ++) {
				cases[i][j] = new Case(i, j);
			}
		}
		cases[1][13] = new CaseBonus(1, 13);
		cases[1][13] = new CaseBonus(1, 13);
	}
	

	public Case getCases(int x, int y) {
		return cases[x][y];
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	@Override
	public String toString() {
		String retour = new String();
		for(int i = 0; i < TAILLE_PLATEAU; i ++) {
			for(int j = 0; j < TAILLE_PLATEAU; j ++) {
				retour += this.getCases(i, j).toString();
			}
			retour += "\n";
		}
		return retour;
	}
}
