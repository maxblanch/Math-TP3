

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatriceTests.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatriceTests
{
    @Test
    public void GIVEN_newInstance_WHEN_creatingMatrixWithSpeceficDimensions_THEN_EmptyMatrixIsCreated() {
        //Arrange
        int nbLignes = 3;
        int nbColonnes = 4;
        
        //Act
        Matrice matrixA = new Matrice(nbLignes, nbColonnes);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[nbLignes][nbColonnes];
        final double[][] ACTUAL_MATRIX = matrixA.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_newInstance_WHEN_creatingMatrixWithOneNumber_THEN_EmptySquareMatrixIsCreated() {
        //Arrange
        int nbLignes = 3;
        
        //Act
        Matrice matrixA = new Matrice(nbLignes);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[nbLignes][nbLignes];
        final double[][] ACTUAL_MATRIX = matrixA.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_newInstance_WHEN_creatingMatrixFromAnotherMatrix_THEN_CopyOfTheMatrixIsCreated() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 2, -3, -7 },
              { 2, -3, 5, 18 },
              { 4, 1, -2, 24 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matrixCopy = new Matrice(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = b;
        final double[][] ACTUAL_MATRIX = matrixCopy.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_newInstance_WHEN_creatingMatrixFromAnotherMatrix_THEN_ExpectDifferentAdressInMemory() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 2, -3, -7 },
              { 2, -3, 5, 18 },
              { 4, 1, -2, 24 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matrixCopy = new Matrice(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = b;
        final double[][] ACTUAL_MATRIX = matrixCopy.a;
        assertNotSame(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatrixIsSquare_THEN_TestSquareMatrixReturnsTrue() {
        //Arrange
        int nbLignes = 2;
        int nbColonnes = 2;
        Matrice matriceB = new Matrice(nbLignes, nbColonnes);
        
        //Act
        boolean isSquareMatrix = matriceB.estCarree();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isSquareMatrix;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatrixIsNotSquare_THEN_TestSquareMatrixReturnsFalse() {
        //Arrange
        int nbLignes = 2;
        int nbColonnes = 3;
        Matrice matriceB = new Matrice(nbLignes, nbColonnes);
        
        //Act
        boolean isSquareMatrix = matriceB.estCarree();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isSquareMatrix;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceEstTriangulaireInférieure_THEN_estTriangulaireInférieureReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0 },
              { 2, -3, 0 },
              { 2, 2, -2 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceInferieure = matriceB.estTriangulaireInferieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isMatriceInferieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Matrice4x4EstTriangulaireInférieure_THEN_estTriangulaireInférieureReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 0 },
              { 2, 1, 0, 0 },
              { 2, 2, 1, 0 },
              { 2, 2, 2, 1 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceInferieure = matriceB.estTriangulaireInferieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isMatriceInferieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
<<<<<<< HEAD
    public void GIVEN_Matrix_WHEN_MatriceEstNulle_THEN_estNulleReturnsTrue(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
=======
    public void GIVEN_Matrix_WHEN_MatriceNEstPasCarree_THEN_estTriangulaireInférieureReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 0 },
              { 2, 1, 0, 0 },
              { 2, 2, 1, 0 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceInferieure = matriceB.estTriangulaireInferieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isMatriceInferieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceCarreeNestPasTriangulaireInferieure_THEN_estTriangulaireInférieureReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 1 },
              { 2, 1, 0, 0 },
              { 2, 2, 1, 0 },
              { 2, 2, 2, 1 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceInferieure = matriceB.estTriangulaireInferieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isMatriceInferieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceEstTriangulaireSuperieure_THEN_estTriangulaireSuperieureReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 0, 1, 1, 1 },
              { 0, 0, 1, 1 },
              { 0, 0, 0, 1 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceSuperieure = matriceB.estTriangulaireSuperieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;;
        final boolean ACTUAL_ANSWER = isMatriceSuperieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceNEstPasTriangulaireSuperieure_THEN_estTriangulaireSuperieureReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 0, 1, 1, 1 },
              { 0, 0, 1, 1 },
              { 4, 1, 0, 1 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isMatriceSuperieure = matriceB.estTriangulaireSuperieure();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isMatriceSuperieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceIsDiagonale_THEN_estDiagonaleReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 0 },
              { 0, 3, 0, 0 },
              { 0, 0, 2, 0 },
              { 0, 0, 0, 1 }
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
<<<<<<< HEAD
        boolean estNulle = matriceB.estNulle();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = estNulle;
=======
        boolean isMatriceDiagonale = matriceB.estDiagonale();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isMatriceDiagonale;
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
<<<<<<< HEAD
    public void GIVEN_Matrix_WHEN_MatriceIsntNulle_THEN_estNulleReturnsfalse(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 1, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
=======
    public void GIVEN_Matrix_WHEN_MatriceIsNotDiagonale_THEN_estDiagonaleReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 2, 0 },
              { 0, 0, 0, 1 }
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
<<<<<<< HEAD
        boolean estNulle = matriceB.estNulle();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = estNulle;
=======
        boolean isMatriceDiagonale = matriceB.estDiagonale();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isMatriceDiagonale;
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
<<<<<<< HEAD
    public void GIVEN_Matrix_WHEN_MatriceEstLigne_THEN_estLigneReturnsTrue(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 }
=======
    public void GIVEN_Matrix_WHEN_MatriceScalaire_THEN_estScalaireReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 8, 0, 0, 0 },
              { 0, 8, 0, 0 },
              { 0, 0, 8, 0 },
              { 0, 0, 0, 8 }
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
<<<<<<< HEAD
        boolean estLigne = matriceB.estLigne();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = estLigne;
=======
        boolean isMatriceScalaire = matriceB.estScalaire();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isMatriceScalaire;
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
<<<<<<< HEAD
    public void GIVEN_Matrix_WHEN_MatriceNestPasLigne_THEN_estLigneReturnsFalse(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
=======
    public void GIVEN_Matrix_WHEN_MatriceIsNotScalaire_THEN_estScalaireReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 8, 0, 0, 0 },
              { 0, 2, 0, 0 },
              { 0, 0, 8, 0 },
              { 0, 0, 0, 8 }
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
<<<<<<< HEAD
        boolean estLigne = matriceB.estLigne();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = estLigne;
=======
        boolean isMatriceScalaire = matriceB.estScalaire();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isMatriceScalaire;
>>>>>>> 1b99118bcd9a435f4b4c3837f788e05cbbb4789b
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
}
