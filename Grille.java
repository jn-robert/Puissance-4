public class Grille {
    protected static int longueurX ;
    protected static int largeurY;

    public Grille(int x, int y){
        this.largeurY = y;
        this.longueurX = x;
    }

    public static boolean estGagnee(int x, int y, Pion[][] grille){
        if(Grille.ligneGagnante(x,y,grille) || Grille.colonneGagnante(x,y,grille) || Grille.diagonaleGagnante(x,y,grille))
            return true;
        return false;
    }

    public static boolean ligneGagnante(int x,int y,Pion[][] grid){
        if(y >= largeurY-3)
            return  false;
        if(grid[x][y] != null && grid[x][y] == grid[x][y+1] && grid[x][y] == grid[x][y+2] && grid[x][y] == grid[x][y+3])
            return true;
        return false;
    }

    public static boolean colonneGagnante(int x,int y,Pion[][] grid){
        if(x > longueurX-4)
            return false;
        if (grid[x][y] != null && grid[x][y] == grid[x+1][y] && grid[x][y] == grid[x+2][y] && grid[x][y] == grid[x+3][y])
            return true;
        return false;
    }

    public static boolean diagonaleGagnante(int x,int y,Pion[][] grid){
        if(x > longueurX-4)
            return false;
        if (y <= largeurY-4){
            if (grid[x][y] != null && grid[x][y] == grid[x+1][y+1] && grid[x][y] == grid[x+2][y+2] && grid[x][y] == grid[x+3][y+3]){
                return true;
            }
        }
        if (y >= largeurY-4){
            if (grid[x][y] != null && grid[x][y] == grid[x+1][y-1] && grid[x][y] == grid[x+2][y-2] && grid[x][y] == grid[x+3][y-3])
                return true;
            return false;
        }
        return false;
    }
}
