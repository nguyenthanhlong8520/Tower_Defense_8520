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
            case 5:
            case 6:
            case 7:
                return 11;
            case 8:
            case 9:
            case 10:
                return 15;
            case 11:
            case 12:
                return 20;
            case 13:
            case 14:
                return 22;
            case 15:
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
                return 5;
            case 5:
            case 6:
            case 7:
            case 8:
                return 10;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 10;
        }
        return 0;
    }

    public int Blood(){
        switch (getWave()){
            case 1:
            case 3:
            case 2:
            case 6:
                return 150;
            case 4:
                return 155;
            case 5:
                return 160;
            case 7:
                return 170;
            case 8:
                return 190;
            case 9:
                return 210;
            case 10:
                return 230;
            case 11:
            case 12:
            case 13:
                return 250;
            case 14:
            case 15:
                return 300;
        }
        return 0;
    }

    public void Rise_Wave(){
        Wave ++;
    }
}
