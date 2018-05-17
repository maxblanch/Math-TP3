

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
    public void GIVEN_Matrix_WHEN_MatriceNEstPasTriangulaireInférieure_THEN_estTriangulaireInférieureReturnsFalse() {
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
    public void GIVEN_Matrix_WHEN_MatriceEstNulle_THEN_estNulleReturnsTrue(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean estNulle = matriceB.estNulle();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = estNulle;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceIsntNulle_THEN_estNulleReturnsfalse(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 1, 0, 0 },
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean estNulle = matriceB.estNulle();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = estNulle;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceEstLigne_THEN_estLigneReturnsTrue(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean estLigne = matriceB.estLigne();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = estLigne;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceNestPasLigne_THEN_estLigneReturnsFalse(){
        //Arrange
        double[][] b = new double[][]{
              { 0, 0, 0, 0 },
              { 0, 0, 0, 0 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean estLigne = matriceB.estLigne();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = estLigne;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
}
