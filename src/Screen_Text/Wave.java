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
                return 7;
            case 3:
                return 9;
            case 4:
                return 11;
            case 5:
                return 15;
            case 6:
                return 17;
            case 7:
                return 19;
            case 8:
                return 21;
            case 9:
                return 23;
            case 10:
                return 25;
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

    public int Blood(){
        switch (getWave()){
            case 1:
                return 50;
            case 2:
                return 110;
            case 3:
                return 120;
            case 4:
                return 130;
            case 5:
                return 170;
            case 6:
                return 190;
            case 7:
                return 230;
            case 8:
                return 300;
            case 9:
                return 400;
            case 10:
                return 480;
        }
        return 0;
    }

    public void Rise_Wave(){
        Wave ++;
    }
}
