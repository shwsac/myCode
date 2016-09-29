package heap;

import java.util.Comparator;
import java.util.PriorityQueue;


class Cell {
    int val;
    int row;
    int col;
    
    Cell(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

public class KthSmallest {
  public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        
        
        Comparator<Cell> comp = new Comparator<Cell>() {
            public int compare(Cell c1,Cell c2) {
                return c1.val - c2.val;
            }
        };
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(comp);
        
        for(int i=0; i < matrix[0].length; i++) {
            queue.offer(new Cell(matrix[0][i], 0,i));
        }
    
        int counter = 0;
        int result = matrix[0][0];
        while(counter != k) {
            Cell first = queue.poll();
            result = first.val;
            int row = first.row;
            int col = first.col;
            
            if(row+1 != matrix.length) {
                 Cell next = new Cell(matrix[row+1][col], row+1, col);
                 queue.offer(next);
            }
            counter++;
        }
        
        return result;
    }
}

