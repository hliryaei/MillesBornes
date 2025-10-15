package cartes;


public class JeuDeCartes {
	private Configuration[] typesDeCartes = new Configuration[19];
	private Carte[] cartes = new Carte[19];

	public JeuDeCartes() {
		int[] nbCartes = new int[] {10,10,10,12,4,14,6,6,6,6,5,4,3,3,3,1,1,1,1};
		cartes[0] = new Borne(25);
		cartes[1] = new Borne(50);
		cartes[2] = new Borne(75);
		cartes[3] = new Borne(100);
		cartes[4] = new Borne(200);
		cartes[5] = new Parade(Type.FEU);
		cartes[6] = new FinLimite();
		cartes[7] = new Parade(Type.ESSENCE);
		cartes[8] = new Parade(Type.CREVAISON);
		cartes[9] = new Parade(Type.ACCIDENT);
		cartes[10] = new Attaque(Type.FEU);
		cartes[11] = new DebutLimite();
		cartes[12] = new Attaque(Type.ESSENCE);
		cartes[13] = new Attaque(Type.CREVAISON);
		cartes[14] = new Attaque(Type.ACCIDENT);
		cartes[15] = new Botte(Type.FEU);
		cartes[16] = new Botte(Type.ESSENCE);
		cartes[17] = new Botte(Type.CREVAISON);
		cartes[18] = new Botte(Type.ACCIDENT);

		for (int i = 0; i<19;i++)
			typesDeCartes[i] = new Configuration(cartes[i], nbCartes[i]);
	}
	
	public Carte[] donnerCartes() {
		int total = 0;
		for(Configuration config: typesDeCartes) {
			total+=config.getNbExemplaires();
		}
		Carte[] allCartes = new Carte[total];
		int index = 0;
		for(Configuration config: typesDeCartes) {
			
			for(int i =0; i< config.getNbExemplaires(); i++) {
				allCartes[index++] = config.getCarte();
			}
		}
		
		return allCartes;
		
	}
	
	
	/*public String affichageJeuDeCartes(){
		StringBuilder info = new StringBuilder();
		for (int i = 0; i<19;i++) {
			info.append(typesDeCartes[i].getNbExemplaires() + " ");
			info.append(typesDeCartes[i].getCarte().toString());
			info.append("\n");
		}
		return info.toString();
	}*/
	
	public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder("JEU:\n");
        for (Configuration cfg : typesDeCartes) {
            sb.append(cfg.getNbExemplaires()).append(" ").append(cfg.getCarte()).append("\n");
        }
        return sb.toString();
    }
	public boolean checkCount() {
		Carte[] all = donnerCartes();
		int total = 0;
		for (Configuration cfg : typesDeCartes) {
		    int expected = cfg.getNbExemplaires();
		    total += expected;
		    int actual = 0;
		    for (Carte c : all) {
		    	if (c.equals(cfg.getCarte())) {
		    		actual++;
		    	}
		    }
		    if (expected != actual) {
		    	System.out.println("Erreur : " + cfg.getCarte() + " attendu " + expected + " trouvé " + actual);
		    	return false;
		    }
		}
		    return all.length == total;
		    }
	
	
	
}