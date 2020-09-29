import java.util.*;

class RandomStrategy{
    private ArrayList<int[]> positions;

    public RandomStrategy(){
        positions = new ArrayList<int[]>();

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                int pos[] = new int[2];

                pos[0] = i;
                pos[1] = j;
                positions.add(pos);
            }
        }
    }

    public int[] nextStrike(){
        Random random = new Random();

        int r = random.nextInt(positions.size());
        int pos[] = positions.get(r);
        return pos;
    }

    public void update(int[] pos){
        positions.remove(pos);
    }
}
