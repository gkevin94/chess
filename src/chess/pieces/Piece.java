package chess.pieces;

import chess.Coordinate;
import chess.FigureArray;
import chess.enums.Color;
import chess.enums.Figure;
import javafx.scene.image.Image;

public abstract class Piece {

    public static Image image = new Image("/chess/piecespics/frm.png");


    public abstract Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate);


    boolean isEnemy(int x, int y, int newX, int newY){
        FigureClass figureClass = FigureArray.getFigureArr()[x][y];
        return isEnemy(figureClass,new Coordinate(newX,newY));
    }

    boolean isEmpty(int x, int y){
        return FigureArray.getFigureArr()[x][y].getFigure() == Figure.EMPTY ;
    }

    boolean isInTheGridPane(int x, int y){
        return x < 8 && x > -1 && y < 8 && y > -1;
    }

    boolean isEnemy(FigureClass figureClass, Coordinate coordinate){

        return FigureArray.getFigureArr()[coordinate.getX()][coordinate.getY()].getColor() != figureClass.getColor() &&
                FigureArray.getFigureArr()[coordinate.getX()][coordinate.getY()].getColor() != Color.EMPTY;
    }

    //    ImageView getChildAtRowCol(int row, int col, ObservableList<Node> children){
//        for (Node child: children){
//            if(GridPane.getColumnIndex(child) == col && GridPane.getRowIndex(child) == row){
//                return (ImageView) child;
//            }
//        }
//        return null;
//    }

//    boolean isEmpty(ImageView imageView){
//        Image image = imageView.getImage();
//        return image == null || image.isError() || imageView.getImage().getUrl().replaceAll("^(.*[/])","").equals("frm.png");
//    }

//    boolean isEmpty(int x, int y, ObservableList<Node> children){
//        ImageView imageView = getChildAtRowCol(y,x,children);
//        Image image = imageView.getImage();
//        return image == null || image.isError() || imageView.getImage().getUrl().replaceAll("^(.*[/])","").equals("frm.png");
//    }

//    boolean checkIfItsEnemy(int oldX, int oldY, int newX, int newY, ObservableList<Node> children){
//        if (isEmpty(getChildAtRowCol(newY,newX, children))) return false;
//        return whatIsMyColor(getChildAtRowCol(newY,newX, children).getImage().getUrl()) != whatIsMyColor(getChildAtRowCol(oldY,oldX,children).getImage().getUrl());
//    }

//    private Color whatIsMyColor(String str){
//        if (str.contains("black_")) return Color.BLACK;
//        else return Color.WHITE;
//    }

}
