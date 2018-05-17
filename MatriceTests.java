

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
    public void GIVEN_Matrix_WHEN_MatriceEstTriangulaireSuperieure_THEN_estSuperieureReturnsTrue() {
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
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isMatriceSuperieure;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceNEstTriangulaireSuperieure_THEN_estSuperieureReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 0, 1, 1, 1 },
              { 0, 0, 1, 1 },
              { 1, 0, 0, 1 }
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
    public void GIVEN_Matrix_WHEN_MatriceEstDiagonale_THEN_estDiagonale() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 0 },
              { 0, 2, 0, 0 },
              { 0, 0, 3, 0 },
              { 0, 0, 0, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isDiagonale = matriceB.estDiagonale();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isDiagonale;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceNEstPasDiagonale_THEN_estDiagonaleReturnFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 0, 0, 1 },
              { 0, 2, 0, 0 },
              { 0, 0, 3, 0 },
              { 0, 0, 0, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isDiagonale = matriceB.estDiagonale();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isDiagonale;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceEstScalaire_THEN_estScalaireReturnsTrue() {
        //Arrange
        double[][] b = new double[][]{
              { 8, 0, 0, 0 },
              { 0, 8, 0, 0 },
              { 0, 0, 8, 0 },
              { 0, 0, 0, 8 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isScalaire = matriceB.estScalaire();
        
        //Assert
        final boolean EXPECTED_ANSWER = true;
        final boolean ACTUAL_ANSWER = isScalaire;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MatriceNEstScalaire_THEN_estScalaireReturnsFalse() {
        //Arrange
        double[][] b = new double[][]{
              { 8, 0, 0, 0 },
              { 0, 2, 0, 0 },
              { 0, 0, 8, 0 },
              { 0, 0, 0, 8 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        boolean isScalaire = matriceB.estScalaire();
        
        //Assert
        final boolean EXPECTED_ANSWER = false;
        final boolean ACTUAL_ANSWER = isScalaire;
        assertEquals(EXPECTED_ANSWER, ACTUAL_ANSWER);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_PermuterDeuxLignes_THEN_LesLignesSontInversées() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.permuteLigne(0, 1);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 2, 2, 2, 2 },
              { 1, 1, 1, 1 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_PermuterDeuxLignes_THEN_LesLignesSontInverséesTest2() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.permuteLigne(0, 3);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 4, 4, 4, 4 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 1, 1, 1, 1 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplierUneLigne_THEN_LaLigneDuTableauEstMultipliéParUnScalaire() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.multiplieLigne(0, 10);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 10, 10, 10, 10 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplierUneLigne_THEN_LaLigneDuTableauEstMultipliéParUnScalaireTest2() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.multiplieLigne(0, 0.5);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 0.5, 0.5, 0.5, 0.5 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_AjoutdUnMultipleDunAutreLigne_THEN_LaLigneDuTableauEstAdditionnéParLautreLigne() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.ajouteMultipleLigne(1, 0, -2.0);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 1, 1, 1 },
              { 0, 0, 0, 0 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_AjoutdUnMultipleDunAutreLigne_THEN_LaLigneDuTableauEstAdditionnéParLautreLigneTest2() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 4, 4, 4, 4 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        matriceB.ajouteMultipleLigne(3, 1, 2);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 1, 1, 1 },
              { 2, 2, 2, 2 },
              { 3, 3, 3, 3 },
              { 8, 8, 8, 8 }
        };
        final double[][] ACTUAL_MATRIX = matriceB.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Transpose3x2Matrix_THEN_MatriceEstTransposeeBecomes2x3() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceTransposé = matriceB.transpose(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 4 },
              { 2, 5 },
              { 3, 6 }
        };
        final double[][] ACTUAL_MATRIX = matriceTransposé.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Transpose3x3Matrix_THEN_MatriceEstTransposeeBecomes3x3() {
        //Arrange
        double[][] b = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 },
              { 7, 8, 9 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceTransposé = matriceB.transpose(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 4, 7 },
              { 2, 5, 8 },
              { 3, 6, 9 }
        };
        final double[][] ACTUAL_MATRIX = matriceTransposé.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Adding3x3Matrices_THEN_ReturnsAddedMatriceResults() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 },
              { 7, 8, 9 }
        };
        Matrice matriceA = new Matrice(a);
        double[][] b = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 },
              { 7, 8, 9 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceC = matriceA.additionMatrices(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 2, 4, 6 },
              { 8, 10, 12 },
              { 14, 16, 18 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Adding2x3Matrices_THEN_ReturnsAddedMatriceResults() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceA = new Matrice(a);
        double[][] b = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceC = matriceA.additionMatrices(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 2, 4, 6 },
              { 8, 10, 12 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_Adding2x3Matrices_THEN_CheckIfOriginalMatriceIsIntact() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceA = new Matrice(a);
        double[][] b = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceC = matriceA.additionMatrices(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 2, 3 },
              { 4, 5, 6 }
        };
        final double[][] ACTUAL_MATRIX = matriceA.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplyMatriceParScalaire_THEN_ReturnsNewMatrixMultipledByScalar() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceA = new Matrice(a);
        final double SCALAIRE = 2.0;
        
        //Act
        Matrice matriceC = matriceA.multiplieScalaire(SCALAIRE);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 2, 4, 6 },
              { 8, 10, 12 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplyMatriceParScalaire_THEN_ReturnsNewMatrixMultipledByScalarTest2() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceA = new Matrice(a);
        final double SCALAIRE = 0.5;
        
        //Act
        Matrice matriceC = matriceA.multiplieScalaire(SCALAIRE);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 0.5, 1, 1.5 },
              { 2, 2.5, 3 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplyMatriceParScalaire_THEN_OriginalMatrixStaysTheSame() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2, 3},
              { 4, 5, 6 }
        };
        Matrice matriceA = new Matrice(a);
        final double SCALAIRE = 0.5;
        
        //Act
        Matrice matriceC = matriceA.multiplieScalaire(SCALAIRE);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 1, 2, 3 },
              { 4, 5, 6 }
        };
        final double[][] ACTUAL_MATRIX = matriceA.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplyMatriceParUneAutreMatrice_THEN_newMatrixisReturned() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2 },
              { 3, 4 }
        };
        Matrice matriceA = new Matrice(a);
        double[][] b = new double[][]{
              { 10 },
              { 10 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceC = matriceA.multiplieMatrices(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 30 },
              { 70 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
    
    @Test
    public void GIVEN_Matrix_WHEN_MultiplyMatriceParUneAutreMatrice_THEN_newMatrixisReturnedTest2() {
        //Arrange
        double[][] a = new double[][]{
              { 1, 2 },
              { 3, 4 }
        };
        Matrice matriceA = new Matrice(a);
        double[][] b = new double[][]{
              { 2, 2 },
              { 2, 2 }
        };
        Matrice matriceB = new Matrice(b);
        
        //Act
        Matrice matriceC = matriceA.multiplieMatrices(matriceB);
        
        //Assert
        final double[][] EXPECTED_MATRIX = new double[][]{
              { 6, 6 },
              { 14, 14 }
        };
        final double[][] ACTUAL_MATRIX = matriceC.a;
        assertEquals(EXPECTED_MATRIX, ACTUAL_MATRIX);
    }
}
