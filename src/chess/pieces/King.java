package chess.pieces;

import chess.Coordinate;
import chess.FigureArray;
import chess.enums.Color;
import chess.enums.Figure;
import chess.enums.MoveList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class King extends Piece {

    private Coordinate coordinate;
    private List<Coordinate> coordinates;


    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        this.coordinate = coordinate;
        coordinates = new ArrayList<>();

        List<MoveList> possibleMoves = Arrays.asList(
                MoveList.DOWN_LEFT,
                MoveList.DOWN_RIGHT,
                MoveList.DOWN,
                MoveList.UP,
                MoveList.UP_RIGHT,
                MoveList.UP_LEFT,
                MoveList.RIGHT,
                MoveList.LEFT);


        for (MoveList m: possibleMoves){
            if (checker(m)) coordinates.add(coordinateMaker(m));
        }

        castlingCheckerAndMaker();

        return coordinates.toArray(new Coordinate[0]);
    }

    private void castlingCheckerAndMaker() {
        switch (FigureArray.getFigureAt(coordinate).getColor()){
            case BLACK: castlingCheckerAndMakerForBlack();
            break;
            case WHITE: castlingCheckerAndMakerForWhite();
            break;
            default:
                break;
        }
    }

    private void castlingCheckerAndMakerForBlack() {
        boolean ok = true;
        if (coordinate.equals(new Coordinate(4,0)) && FigureArray.getFigureAt(coordinate).getSteps() == 0){
            if (FigureArray.getFigureAt(7,0).getFigure() == Figure.B_ROOK && FigureArray.getFigureAt(7,0).getSteps() == 0){
                for (int i = 5; i < 7; i++) {
                    Color c = FigureArray.getFigureAt(i,0).getColor();
                    if (c == Color.BLACK || c == Color.WHITE){
                        ok = false;
                        break;
                    }
                }
                if (ok){
                    coordinates.add(new Coordinate(6,0));
                }
            }
            if (FigureArray.getFigureAt(0,0).getFigure() == Figure.B_ROOK && FigureArray.getFigureAt(0,0).getSteps() == 0){
                ok = true;
                for (int i = 3; i > 0; i--) {
                    Color c = FigureArray.getFigureAt(i,0).getColor();
                    if (c == Color.BLACK || c == Color.WHITE){
                        ok = false;
                        break;
                    }
                }
                if (ok){
                    coordinates.add(new Coordinate(2,0));
                }
            }
        }
    }

    private void castlingCheckerAndMakerForWhite(){
        boolean ok = true;
        if (coordinate.equals(new Coordinate(4,7)) && FigureArray.getFigureAt(coordinate).getSteps() == 0){
            if (FigureArray.getFigureAt(7,7).getFigure() == Figure.W_ROOK && FigureArray.getFigureAt(7,7).getSteps() == 0){
                for (int i = 5; i < 7; i++) {
                    Color c = FigureArray.getFigureAt(i,7).getColor();
                    if (c == Color.BLACK || c == Color.WHITE){
                        ok = false;
                        break;
                    }
                }
                if (ok){
                    coordinates.add(new Coordinate(6,7));
                }
            }
            if (FigureArray.getFigureAt(0,7).getFigure() == Figure.W_ROOK && FigureArray.getFigureAt(0,7).getSteps() == 0){
                ok = true;
                for (int i = 3; i > 0; i--) {
                    Color c = FigureArray.getFigureAt(i,7).getColor();
                    if (c == Color.BLACK || c == Color.WHITE){
                        ok = false;
                        break;
                    }
                }
                if (ok){
                    coordinates.add(new Coordinate(2,7));
                }
            }
        }
    }

    private boolean checker(MoveList moveList){
        int x = coordinate.getX() + moveList.getX();
        int y = coordinate.getY() + moveList.getY();
        return isInTheGridPane(x,y) && (isEmpty(x,y)
                || isEnemy(coordinate.getX(), coordinate.getY(), x, y));
    }

    private Coordinate coordinateMaker(MoveList moveList){
        return new Coordinate(coordinate.getX()+moveList.getX(), coordinate.getY()+moveList.getY());
    }

//    private void castlingCheckerAndMaker(){
//        if ((getChildAtRowCol(coordinate.getY(), coordinate.getX(), children)).getImage().getUrl().contains("black")){
//            if (coordinate.getX() == 4 && coordinate.getY() == 0){
//                if (isEmpty(5,0,children) && isEmpty(6,0,children) &&
//                        getChildAtRowCol(7,0,children).getImage().getUrl().contains("black_rook.png")){
//                    coordinates.add(new Coordinate(6,0));
//                };
//            }
//        } else {
//            if (coordinate.getX() == 4 && coordinate.getY() == 7){
//                if (isEmpty(5,7,children) && isEmpty(6,7,children) &&
//                        getChildAtRowCol(7,7,children).getImage().getUrl().contains("white_rook.png")){
//                    coordinates.add(new Coordinate(6,7));
//                }
//            }
//        }
//    }
}
