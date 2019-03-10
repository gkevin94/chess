package chess.pieces;

import chess.Coordinate;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    private Coordinate coordinate;
    private List<Coordinate> list;


    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        this.coordinate = coordinate;
        list = new ArrayList<>();
        System.out.println(coordinate.toString());
        for (int i = coordinate.getX()+1; i < 8; i++){
            i = checkerForX(i,false);
        }
        for (int l = coordinate.getX()-1; l > -1 ; l--) {
            l = checkerForX(l,true);
        }
        for (int j = coordinate.getY()+1; j < 8; j++) {
            j = checkerForY(j,false);
        }
        for (int k = coordinate.getY()-1; k > -1 ; k--) {
            System.out.println(k);
            k = checkerForY(k,true);
            System.out.println(k);
        }

        Coordinate[] moveLists = new Coordinate[list.size()];
        moveLists = list.toArray(moveLists);
        return moveLists;
    }

    private int checkerForX(int i, boolean DESC){
        if (isEmpty(i,coordinate.getY())){
            list.add(new Coordinate(i,coordinate.getY()));
            return i;
        } else if (isEnemy(coordinate.getX(),coordinate.getY(),i,coordinate.getY())){
            list.add(new Coordinate(i,coordinate.getY()));
            if (DESC) return -1;
            else return 8;
        } else {
            if (DESC) return -1;
            else return 8;
        }
    }

    private int checkerForY(int i, boolean DESC){
        //System.out.println(isEnemy(coordinate.getX(),coordinate.getY(),coordinate.getX(),i) + ", " + new Coordinate(coordinate.getX(),i).toString());
        if (isEmpty(coordinate.getX(),i)){
            list.add(new Coordinate(coordinate.getX(),i));
            return i;
        } else if (isEnemy(coordinate.getX(),coordinate.getY(),coordinate.getX(),i)){
            list.add(new Coordinate(coordinate.getX(), i));
            if (DESC) return -1;
            else return 8;
        } else {
            if (DESC) return -1;
            else return 8;
        }
    }
}