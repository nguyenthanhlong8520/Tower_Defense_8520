package Object_In_Game.Entity;

public class Road extends Abt_Entity{

    private static double x , y, width,height;

    public Road(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public  boolean Land_Tower(){
        if ( y > 283 && y < 350 && x > 619 || x > 1000 ){
            return false;
        }
        if ( x > 618 && x < 683 && y > 353 && y < 487 ) {
            return false;
        }
        if ( y > 428 && y < 488 && x > 343 && x < 682 ) {
            return false;
        }
        if (x > 344 && x < 407 && y < 486 && y > 146){
            return false;
        }
        if (y > 145 && y < 207 && x > 138 && x < 407 ){
            return false;
        }
        if (x > 139 && x < 205 && y > 211 && y < 419){
            return false;
        }
        if (y > 356 && y < 424 && x < 203 ){
            return false;
        }
        if ( x >= 581 && x <= 581 + 112 && y >= 190 && y <= 190+112 ){
            return false;
        }
        if (x >= 43 && x <= 43 + 112 && y >= 110 && y <= 110+112 ){
            return false;
        }
        return true;
    }

    @Override
    public double getX() {
        return  x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
