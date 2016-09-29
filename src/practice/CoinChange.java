package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Cell {
    int minCoins;
    List<Integer> coins;
    
    Cell (int minCoins) {
        this.minCoins = minCoins;
        coins = new ArrayList<Integer>();
    }
    
    int getCoins() {
        return minCoins;
    }
    
    void addCoin(int coin) {
        this.coins.add(coin);
    }
    
    void addCoinList(List<Integer> coinList) {
        for(int coin :coinList) {
            coins.add(coin);
        }
    }
    
    List<Integer> getCoinList() {
        return coins;
    }
}

public class CoinChange {
    
    public static List<Integer> getCoinChange(int[] denom, int n) {
        if(n <= 0) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Cell[][] minCoins = new Cell[denom.length+1][n+1];
        for(int i=0 ; i< minCoins[0].length; i++) {
            Cell cell = new Cell(i);
            minCoins[0][i] = cell;
        }
        for(int j=0 ; j< minCoins.length; j++) {
            Cell cell = new Cell(0);
            minCoins[j][0] = cell;
        }
        for(int i = 1; i< minCoins.length; i++) {
            for(int j = 1; j< minCoins[0].length; j++) {
                if(denom[i-1] > j) {
                    minCoins[i][j] = minCoins[i-1][j];
                }
                else {
                    int diff = j - denom[i-1];
                    int p = minCoins[i-1][j].getCoins();
                    int q = 1+ minCoins[i][diff].getCoins();
                    if(p < q ) {
                        minCoins[i][j] = minCoins[i-1][j];
                    }
                    else {
                        Cell cell = new Cell(q);
                        cell.addCoinList(minCoins[i][diff].getCoinList());
                        cell.addCoin(denom[i-1]);
                        minCoins[i][j] = cell;
                    }
                }
            }
        }
        result.addAll(minCoins[denom.length][n].getCoinList());
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] denom = {1,5,25};
        Random r = new Random();
        for(int i = 0; i < 20; i++){
            int num = r.nextInt(100);
            List<Integer> result = getCoinChange(denom,num);
            System.out.print(num + " : ");
            System.out.println(result);
        }
    }

}
