package chess.pieces;

import chess.Coordinate;
import chess.enums.MoveList;

import java.util.ArrayList;
import java.util.List;

public class BlackPawn extends Piece {


    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        int X = coordinate.getX();
        int Y = coordinate.getY();
        List<Coordinate> coordinates = new ArrayList<>();
            if (Y == 1 && inGridPaneAndEmptyAndNotEnemyChecker(X, Y, MoveList.DOUBLE_UP)){
                coordinates.add(new Coordinate(MoveList.DOUBLE_UP.getX() + X, MoveList.DOUBLE_UP.getY() + Y));
            }
            if (inGridPaneAndEmptyAndNotEnemyChecker(X, Y, MoveList.UP)){
                coordinates.add(new Coordinate(MoveList.UP.getX() + X, MoveList.UP.getY() + Y));
            }
            if (inGridPaneAndEmptyAndEnemyChecker(X,Y,MoveList.UP_LEFT)){
                coordinates.add(new Coordinate(MoveList.UP_LEFT.getX() + X, MoveList.UP_LEFT.getY() + Y));
            }
            if (inGridPaneAndEmptyAndEnemyChecker(X,Y,MoveList.UP_RIGHT)){
                coordinates.add(new Coordinate(MoveList.UP_RIGHT.getX() + X, MoveList.UP_RIGHT.getY() + Y));
            }
            return coordinates.toArray(new Coordinate[0]);
    }

    private boolean inGridPaneAndEmptyAndNotEnemyChecker(int X, int Y, MoveList moveList){
        int newX = X+moveList.getX();
        int newY = Y+moveList.getY();
        return isInTheGridPane(newX,newY) && isEmpty(newX,newY) && !isEnemy(X,Y,newX,newY);
    }

    private boolean inGridPaneAndEmptyAndEnemyChecker(int X, int Y, MoveList moveList){
        int newX = X+moveList.getX();
        int newY = Y+moveList.getY();
        return isInTheGridPane(newX,newY) && isEnemy(X,Y,newX,newY);
    }


}
