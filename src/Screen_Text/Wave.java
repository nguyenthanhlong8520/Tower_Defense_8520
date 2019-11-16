package Screen_Text;

public class Wave {
    int Wave;

    public int getWave() {
        return Wave;
    }

    public void setWave(int wave) {
        Wave = wave;
    }

    public int Limit_Monster(){
        switch (getWave()){
            case 1 :
                return 5;
            case 2:
                return 10;
            case 3:
                return 15;
        }
        return 0;
    }

    public void Rise_Wave(){
        Wave ++;
    }
}
