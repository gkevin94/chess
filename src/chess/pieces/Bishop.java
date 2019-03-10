package chess.pieces;

import chess.Coordinate;
import chess.enums.MoveList;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    private Coordinate coordinate;
    private List<Coordinate> coordinates;


    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        this.coordinate = coordinate;
        coordinates = new ArrayList<>();

        boolean end = false;
        int i = 1;
        // UP LEFT
        while (!end){
            end = checker(i,MoveList.UP_LEFT);
            i++;
        }
        // UP RIGHT
        end = false;
        i = 1;
        while (!end){
            end = checker(i,MoveList.UP_RIGHT);
            i++;
        }
        // DOWN LEFT
        end = false;
        i = 1;
        while (!end){
            end = checker(i, MoveList.DOWN_LEFT);
            i++;
        }
        // DOWN RIGHT
        end = false;
        i = 1;
        while (!end) {
            end = checker(i, MoveList.DOWN_RIGHT);
            i++;
        }

        return coordinates.toArray(new Coordinate[0]);
    }

    private boolean checker(int i, MoveList moveList){
        int x = coordinate.getX() + (i * moveList.getX());
        int y = coordinate.getY() + (i * moveList.getY());
        if (isInTheGridPane(x,y) && isEmpty(x,y)){
            coordinates.add(new Coordinate(x,y));
            return false;
        } else if (isInTheGridPane(x,y) && isEnemy(coordinate.getX(),coordinate.getY(), x, y)){
            coordinates.add(new Coordinate(x,y));
            return true;
        } else {
            return true;
        }
    }
}
