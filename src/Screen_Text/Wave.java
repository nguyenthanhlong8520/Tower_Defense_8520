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
                return 1;
            case 2:
                return 8;
            case 3:
            case 4:
                return 13;
            case 5:
                return 15;
            case 6:
                return 17;
            case 7:
            case 8:
            case 9:
                return 19;
            case 10:
                return 25;
        }
        return 0;
    }

    public int Speed(){
        switch (getWave()){
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 2:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
        }
        return 0;
    }

    public void Rise_Wave(){
        Wave ++;
    }
}
