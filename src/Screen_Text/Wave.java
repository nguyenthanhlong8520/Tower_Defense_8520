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
                return 2;
            case 2:
                return 25;
            case 3:
            case 4:
                return 31;
            case 5:
                return 35;
            case 6:
                return 40;
            case 7:
            case 8:
            case 9:
                return 45;
            case 10:
                return 50;
        }
        return 0;
    }

    public int Speed(){
        switch (getWave()){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 5;
            case 8:
            case 9:
            case 10:
                return 10;
        }
        return 0;
    }

    public void Rise_Wave(){
        Wave ++;
    }
}
