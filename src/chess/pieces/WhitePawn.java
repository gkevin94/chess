package chess.pieces;

import chess.Coordinate;
import chess.enums.MoveList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class WhitePawn extends Piece {

    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        int X = coordinate.getX();
        int Y = coordinate.getY();
        List<Coordinate> coordinates = new ArrayList<>();
        if (inGridPaneAndEmptyAndNotEnemyChecker(X, Y, MoveList.DOUBLE_DOWN) && Y == 6){
            coordinates.add(new Coordinate(MoveList.DOUBLE_DOWN.getX() + X, MoveList.DOUBLE_DOWN.getY() + Y));
        }
        if (inGridPaneAndEmptyAndNotEnemyChecker(X, Y, MoveList.DOWN)){
            coordinates.add(new Coordinate(MoveList.DOWN.getX() + X, MoveList.DOWN.getY() + Y));
        }
        if (inGridPaneAndEmptyAndEnemyChecker(X,Y,MoveList.DOWN_LEFT)){
            coordinates.add(new Coordinate(MoveList.DOWN_LEFT.getX() + X, MoveList.DOWN_LEFT.getY() + Y));
        }
        if (inGridPaneAndEmptyAndEnemyChecker(X,Y,MoveList.DOWN_RIGHT)){
            coordinates.add(new Coordinate(MoveList.DOWN_RIGHT.getX() + X, MoveList.DOWN_RIGHT.getY() + Y));
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
