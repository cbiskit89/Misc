public class Percolation {
    private boolean[][] grid;
    private int n;
    private WeightedQuickUnionUF QF;
    
    public Percolation(int N) {
        // create N-by-N grid, with all sites blocked
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than 0.");
        }
        grid = new boolean[N + 1][N + 1];
        QF = new WeightedQuickUnionUF((N * N) + 2);
        for (int i = 1; i <= N; i++) {
            QF.union(0, i);
            QF.union((N * (N - 1) + i), (N * N) + 1);
        }
        n = N;
    }
    public void open(int i, int j) {
        // open site (row i, column j) if it is not open already
        boundsCheck(i, j);
        grid[i][j] = true;
        if (i > 1 && grid[i][j] && grid[i-1][j]) { 
            QF.union(xyTo1D(i, j), xyTo1D(i-1, j)); 
        }
        if (i < n && grid[i][j] && grid[i+1][j]) { 
            QF.union(xyTo1D(i, j), xyTo1D(i+1, j)); 
        }
        if (j > 1 && grid[i][j] && grid[i][j-1]) { 
            QF.union(xyTo1D(i, j), xyTo1D(i, j-1)); 
        }
        if (j < n && grid[i][j] && grid[i][j+1]) { 
            QF.union(xyTo1D(i, j), xyTo1D(i, j+1)); 
        }
    }
    public boolean isOpen(int i, int j) {
        // is site (row i, column j) open?
        boundsCheck(i, j);
        return grid[i][j];
    }
    public boolean isFull(int i, int j) {
        // is site (row i, column j) full?
        if (grid[i][j]) { 
            return QF.connected(xyTo1D(i, j), 0); 
        }
        return false;
    }
    public boolean percolates() {
        // does the system percolate?
        return QF.connected(0, n * n + 1);
    }
    
    public static void main(String[] args) {
        // test client (optional)
    }
    
    private void boundsCheck(int i, int j) {  
        // check if within 1 and N
        if (i > n || i < 1 || j > n || j < 1) { 
            throw new IndexOutOfBoundsException("Index " + i + ", " + j 
                                                    + " is out of bounds.");
        } 
    }
    
    private int xyTo1D(int i, int j) {
        // map 2D array to 1D array
        return n * (i - 1) + j;
    }
}