package leetcodepremium;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Stock {
    public String ticker;
    public int count;

    Stock(String ticker, int count) {
        this.ticker = ticker;
        this.count = count;
    }

    public void changeValue(int count) {
        this.count = count;
    }
}

class MyComparator<Stock> implements Comparator<Stock> {
    
    @Override
    public int compare(Stock s1, Stock s2) {
        return s1.count - s2.count;
    }
}

public class MostTradedStocks {
    
    PriorityQueue<Stock> queue = new PriorityQueue<Stock>(new MyComparator<Stock>());
    HashMap<String,Stock> hMap = new HashMap<String,Stock>();
    
    public void addTrade(String ticker) {
        if(!hMap.containsKey(ticker)) {
            Stock s = new Stock(ticker,1);
            hMap.put(ticker, s);
            queue.offer(s);
        }
        else {
            Stock s = hMap.get(ticker);
            s.changeValue(s.count+1);
            Collections.sort(queue,new MyComparator<Stock>());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}



