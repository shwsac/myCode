package leetcodepremium;

public class CircularArray {
    double[] buffer;
    int read;
    int write;
    
    CircularArray(int size) {
        this.buffer = new double[size];
        this.read = 0;
        this.write = 0;
    }
    
    public void enqueue(double x) {
        //queue is full
        if(read == (write+1) % (buffer.length)){
            buffer[read] = x;
            write = read;
            read = (read +1) % (buffer.length);
            return;
        }
     
        buffer[write] = x;
        write = (write + 1) % (buffer.length);
    }
    
    public double dequeue() throws Exception {
        if(read == write) {
            throw new Exception ("Queue is empty");
        }
        double r = buffer[read];
        read = (read + 1) % (buffer.length);
        
        return r;
    }
}
