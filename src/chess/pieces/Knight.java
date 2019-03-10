package chess.pieces;

import chess.Coordinate;
import chess.FigureArray;
import chess.enums.Figure;
import chess.enums.MoveList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    private Coordinate coordinate;
    private List<Coordinate> coordinates;

    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        this.coordinate = coordinate;
        coordinates = new ArrayList<>();

        for (MoveList m: MoveList.values()){
            if (m.name().contains("KNIGHT") && inGridPaneAndNotMe(m)){
                coordinates.add(coordinateMaker(m));
            }
        }
        return coordinates.toArray(new Coordinate[0]);
    }

    private boolean inGridPaneAndNotMe(MoveList moveList){
        int x = coordinate.getX() + moveList.getX();
        int y = coordinate.getY() + moveList.getY();
        if (isInTheGridPane(x,y)){
            FigureClass figureClass = FigureArray.getFigureArr()[x][y];
            return (figureClass.getFigure() == Figure.EMPTY || isEnemy(figureClass,coordinate));
        }
        return false;
    }

    private Coordinate coordinateMaker(MoveList moveList){
        return new Coordinate(coordinate.getX()+moveList.getX(), coordinate.getY()+moveList.getY());
    }
}
