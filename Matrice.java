
public class Matrice {

    public double[][] a;   // le tableau
    private int m;          // nombre de lignes
    private int n;          // nombre de colonnes

    public static void main(String[] args) {
        
        // AVANT DE FAIRE LES EXERCICES DU TP3, VOUS DEVEZ IMPLEMENTER LES METHODES ET OBTENIR LE BON RESULTAT !
        // (notes de cours p.153)
        double[][] b = new double[][]{
              { 1, 2, -3, -7 },
              { 2, -3, 5, 18 },
              { 4, 1, -2, 24 }
        };
        
        Matrice m = new Matrice(b);
        
        m.affiche();
        
        m.ajouteMultipleLigne(1, 0, -2);
        m.ajouteMultipleLigne(2, 0, -4);
        m.ajouteMultipleLigne(2, 1, -1);
        m.multiplieLigne(1, -1./7.);
        m.multiplieLigne(2, -1);
        m.ajouteMultipleLigne(0, 1, -2);
        m.ajouteMultipleLigne(0, 2, -0.1428571428571428); 
        m.ajouteMultipleLigne(1, 2, 1.5714285714285714);
        
        // etes-vous en mesure d'expliquer la perte de precision dans l'affichage de la reponse finale ??
        m.affiche();
    }
    
    /**
     * Cree une matrice m par n
     */
    public Matrice(int nbLignes, int nbColonnes) {
        this.m = nbLignes;
        this.n = nbColonnes;
        this.a = new double[m][n];
    }
    
    /**
     * Cree une matrice carree n par n
     */
    public Matrice(int nbLignes) {
        this.m = nbLignes;
        this.n = nbLignes;
        this.a = new double[m][n];
    }
    
    public Matrice(double[][] b) {
        m = b.length;
        n = b[0].length;
        a = new double[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }
    
    /**
     * Copie une matrice b
     */
    public Matrice(Matrice b) {
        this.a = new double[b.a.length][];
        for(int i = 0; i < b.a.length; i++) {
            this.a[i] = b.a[i].clone();
        }
    }
    
    public void affiche() {
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public int getNbLignes() {
        return m;
    }

    public int getNbColonnes() {
        return n;
    }
    
    public double getElement(int ligne, int colonne) {
        return a[ligne][colonne];
    }

    public void setElement(double e, int ligne, int colonne) {
        a[ligne][colonne] = e;
    }
    
    public boolean estCarree() {
        return this.getNbLignes() == this.getNbColonnes();
    }

    public boolean estTriangulaireInferieure() {
        if(!this.estCarree()) return false;
        boolean estTrianglulaireInferieure = true;
        int indexBlocker = 1;
        for(int i=0; i<this.getNbLignes(); i++) {
            for(int j=this.getNbColonnes() - 1; j>indexBlocker; j--) {
                if(this.getElement(i,j) != 0) {
                    estTrianglulaireInferieure = false;
                    break;
                }
            }
            indexBlocker++;
        }
        return estTrianglulaireInferieure;
    }
    
    public boolean estTriangulaireSuperieure() {
        if(!this.estCarree()) return false;
        boolean estTrianglulaireSuperieure = true;
        int indexBlocker = this.getNbLignes() - 1;
        for(int i=this.getNbLignes() - 1; i>0; i--) {
            for(int j=0; j<indexBlocker; j++) {
                if(this.getElement(i,j) != 0) {
                    estTrianglulaireSuperieure = false;
                    break;
                }
            }
            indexBlocker--;
        }
        return estTrianglulaireSuperieure;
    }
    
    public boolean estDiagonale() {
        boolean estDiagonale = false;
        if(this.estTriangulaireInferieure()) {
            if(this.estTriangulaireSuperieure()) {
                estDiagonale = true;
                int diagonaleIndex = 0;
                for(int i=0; i<this.getNbLignes(); i++) {
                    if(this.getElement(i,diagonaleIndex) == 0) {
                        estDiagonale = false;
                        break;
                    }
                    diagonaleIndex++;
                }
            }
        }
        return estDiagonale;
    }

    public boolean estScalaire() {
        if(!estDiagonale()) return false;
        int diagonaleIndex = 0;
        double nombreScalaire = this.getElement(0,0);
        for(int i=0; i<this.getNbLignes(); i++) {
            if(this.getElement(i,diagonaleIndex) != nombreScalaire) {
                return false;
            }
            diagonaleIndex++;
        }
        return true;
    }
    
    public boolean estNulle() {
        // TODO
        return true;
    }

    public boolean estLigne() {
        // TODO
        return true;
    }
    
    public boolean estColonne() {
        // TODO
        return true;
    }
    
    public boolean estSymetrique() {
        // TODO
        return true;
    }
    
    /**
     * Operation elementaire sur les lignes.
     * Permute la ligne i de la matrice avec la ligne j de la matrice.
     * L_i <-> L_j
     */
    public void permuteLigne(int i, int j) {
        // TODO
    }

    /**
     * Operation elementaire sur les lignes.
     * Multiplie la ligne i par le facteur d.
     * L_i <- d * L_i
     */
    public void multiplieLigne(int i, double d) {
        // TODO
    }

    /**
     * Operation elementaire sur les lignes.
     * Ajoute a une ligne un multiple d'une autre ligne.
     * L_i <- L_i + d * L_j
     */
    public void ajouteMultipleLigne(int i, int j, double d) {
        // TODO
    }

    /**
     * Construit une matrice identite n par n
     */
    public Matrice identite(int n) {
        // TODO
        return null;
    }
    
    /**
     * Construit une matrice scalaire n par n ayant le nombre e sur la diagonale.
     */
    public Matrice scalaire(double e, int n) {
        // TODO
        return null;
    }
    
    /**
     * Retourne la matrice transposee de la matrice passee en argument
     */
    public Matrice transpose(Matrice mat) {
        // TODO
        return mat;
    }
    
    /**
     * Multiplie tous les termes de la matrice par le scalaire k. 
     * Retourne la matrice obtenue (la matrice de depart est inchangee : une nouvelle matrice est creee)
     */
    public Matrice multiplieScalaire(double k) {
        // TODO
        return null;
    }
    
    /**
     * Additionne une matrice a la matrice.
     * Retourne la matrice somme (la matrice de depart est inchangee : une nouvelle matrice est creee)
     */
    public Matrice additionMatrices(Matrice b) {
        // TODO
        return null;
    }
    
    /**
     * Multiplie une matrice a la matrice.
     * Retourne la matrice produit (la matrice de depart est inchangee : une nouvelle matrice est creee)
     */
    public Matrice multiplieMatrices(Matrice b) {
        // TODO
        return null;
    }
    
    public void question1() {
        // TODO
    }

    public void question2() {
        // TODO
    }

    public void question3() {
        // TODO
    }

    public void question4() {
        // TODO
    }
    
}

