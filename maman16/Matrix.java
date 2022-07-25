/**
 * @ Shahar Gilad
 * 
 * This class represents 2 dimensional Matrix array of integers between 0 - 255.
 *
 * @1.0
 */
public class Matrix
{
    private int[][] _matrix;
    private final int MAX_INT = 255;
    
    
    /**
     * Constructor for a Matrix objec.
     * @param array two diamentional array.
     */
    public Matrix(int[][] array){
        _matrix = new int[array.length][array[0].length];// initializing the matrix
        
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                _matrix[i][j] = array[i][j];
            }
        }
    }
    
    
    /**
    * Constructs a size1 by size2 Matrix of zeroes.
    * @param size1 the num of rows
    * @param size2 the num of cols
    */    
    public Matrix(int size1, int size2){
        _matrix = new int[size1][size2];// initializing the matrix
    }
    
    
    /**
    * Return the matrix as a string 
    * @return string represent the matrix
    */ 
    public String toString(){
        String str = "";
        
        for(int i = 0; i < getOutterSize(); i++){
            for(int j = 0; j < getInnerSize()-1; j++){
                str += _matrix[i][j] + "\t";
            }
            str += _matrix[i][getInnerSize() - 1] + "\n"; //The last one
        }
        return str;
    }
    
    
    /**
    * Create a new negative Matrix 
    * @return negative Matrix
    */
    public Matrix makeNegative(){
        int[][] negativeArray = new int [getOutterSize()][getInnerSize()];
        for(int i = 0; i < getOutterSize(); i++){
            for(int j = 0; j < getInnerSize(); j++){
                negativeArray[i][j] = MAX_INT - (_matrix[i][j]); //Make negative
            }
        }
        return new Matrix(negativeArray);
    }

    
    /**
    * Create a new fliped horizontal.
    * @return fliped horizontal Matrix
    */
    public Matrix flipHorizontal(){
        int[][] flipArray = new int [getOutterSize()][getInnerSize()];
        for(int i= 0; i < getOutterSize(); i++){
            for(int j = 0; j < getInnerSize(); j++){
                flipArray[getOutterSize() - 1 - i][j] = _matrix[i][j];
            }
        }
        return new Matrix(flipArray);
    }

    
    /**
    * Create a new fliped vertical Matrix.
    * @return fliped vertical Matrix
    */
    public Matrix flipVertical(){
        int[][] flipArray = new int [getOutterSize()][getInnerSize()];
        for(int i = 0; i < getOutterSize() ; i++){
            for(int j = 0; j < getInnerSize(); j++){
                flipArray[i][getInnerSize() - 1 -j] = _matrix[i][j];
            }
        }
        return new Matrix(flipArray);
    }
    
    
    /**
    * Create a new clockwise rotate Matrix.
    * @return Matrix clockwise rotate
    */
    public Matrix rotateClockwise(){
        int[][] rotateArray = new int[getInnerSize()][getOutterSize()];
        for(int i = 0 ; i < getOutterSize(); i++){
            for(int j = 0; j < getInnerSize(); j++){
                rotateArray[j][getOutterSize() - 1 - i] = _matrix[i][j];
            }
        }
        return new Matrix(rotateArray);
    }

    
    /**
    * Create a new -90 degrees rotate Matrix.
    * @return Matrix -90 degrees rotate Matrix.
    */
    public Matrix rotateCounterClockwise(){
        int[][] rotateArray = new int[getInnerSize()][getOutterSize()];
        for(int i = 0 ; i < getOutterSize(); i++){
            for(int j = 0 ; j < getInnerSize(); j++){
                rotateArray[getInnerSize() - 1 - j][i] = _matrix[i][j];
            }
        }
        return new Matrix(rotateArray);
    }

    /**
     * Private Functions
     */
    
    
    /**
    * Return the outer array length
    * @return int
    */
    private int getOutterSize(){
        return _matrix.length;
    }
    
    /**
    * Return the inner array length
    * @return int
    */
    private int getInnerSize(){
        return _matrix[0].length;
    }
}
