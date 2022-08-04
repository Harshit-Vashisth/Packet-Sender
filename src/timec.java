public class timec implements Runnable {
    int count=0;
    public timec(){

    }
    int set(){
        return count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
                count++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
