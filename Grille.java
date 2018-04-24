package Puissance;

public class Grille {
    private Pion[] grid = new Pion[7*6];
    private static int ligne = 7;

    public static boolean estGagnee(int i, Pion[] grille){
        if(Grille.ligneGagnante(i,grille) || Grille.colonneGagnante(i,grille) || Grille.diagonaleGGagnante(i,grille))
            return true;
        return false;
    }

    public static boolean ligneGagnante(int x,Pion[] grid){
        if(x%ligne > 4)
            return  false;
        if(grid[x] != null && grid[x] == grid[x+1] && grid[x] == grid[x+2] && grid[x] == grid[x+3])
            return true;
        return false;
    }

    public static boolean colonneGagnante(int x,Pion[] grid){
        if(x > ligne*3)
            return false;
        if (grid[x] != null && grid[x] == grid[ligne + x] && grid[x] == grid[2*ligne + x] && grid[x] == grid[3*ligne + x])
            return true;
        return false;
    }

    public static boolean diagonaleGGagnante(int x,Pion[] grid){
        if(x > ligne*3)
            return false;
        if (x%ligne <= ligne-3){
            if (grid[x] != null && grid[x] == grid[x+ligne+1] && grid[x] == grid[x+2*ligne+2] && grid[x] == grid[x+3*ligne+3]){
                return true;
            }
        }
        if (x%ligne > 3){
            if (grid[x] != null && grid[x] == grid[x+ligne-1] && grid[x] == grid[x+2*ligne-2] && grid[x] == grid[x+3*ligne-3])
                return true;
            return false;
        }
        return false;
    }
}
