package chess.secondtr;

import chess.Coordinate;
import chess.FigureArray;
import chess.enums.Figure;
import chess.pieces.FigureClass;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Highligther {

    public ObservableList<Node> children;
    private Image image = new Image("/chess/piecespics/frm.png");
    private List<ImageView> highlighted = new ArrayList<>();


    public void setChildren(ObservableList<Node> children) {
        this.children = children;
    }

    protected void highlightPossibleSteps(FigureClass figureClass) {
        Coordinate[] coordinates = figureClass.stepWithFigure();
        for (Coordinate c : coordinates) {
            imageSetter(c);
        }
    }

    private void imageSetter(Coordinate c) {
        ImageView imageView = getChildAtRowCol(c.getX(), c.getY());
        FigureClass figureClass = FigureArray.getFigureArr()[c.getX()][c.getY()];
        if (figureClass.getFigure() == Figure.EMPTY) {
            imageView.setImage(image);
        } else {
            imageViewSetterForEnemy(c.getX(),c.getY());
        }
        highlighted.add(imageView);
    }

    private ImageView getChildAtRowCol(int col, int row) {
        for (Node child : children) {
            if (GridPane.getColumnIndex(child) == col && GridPane.getRowIndex(child) == row) {
                return (ImageView) child;
            }
        }
        return null;
    }

    protected void stepOver(Coordinate fromC, Coordinate toC) {
        if (!needForCastling(fromC,toC)){
            step(fromC, toC);
        } else {
            castlingStep(fromC, toC);
        }
    }

    private boolean needForCastling(Coordinate fromC, Coordinate toC){
        Figure figure = FigureArray.getFigureAt(fromC).getFigure();
        if (figure == Figure.B_KING){
            return ((toC.getX() == 2 && toC.getY() == 0) || (toC.getX() == 6 && toC.getY() == 0));
        } else if (figure == Figure.W_KING) {
            return ((toC.getX() == 2 && toC.getY() == 7) || (toC.getX() == 6 && toC.getY() == 7));
        } else {
            return false;
        }
    }

    private void castlingStep(Coordinate fromC, Coordinate toC) {
        Figure figure = FigureArray.getFigureAt(fromC).getFigure();
        if (figure == Figure.B_KING){
            if (toC.equals(new Coordinate(6,0))){
                step(fromC, toC);
                step(new Coordinate(7,0), new Coordinate(toC.getX()-1, fromC.getY()));
            } else {
                step(fromC, toC);
                step(new Coordinate(0,0), new Coordinate(toC.getX()+1, fromC.getY()));
            }
        } else {
            if (toC.equals(new Coordinate(6,7))){
                step(fromC, toC);
                step(new Coordinate(7,7), new Coordinate(toC.getX()-1, fromC.getY()));
            } else {
                step(fromC, toC);
                step(new Coordinate(0,7), new Coordinate(toC.getX()+1, fromC.getY()));
            }
        }
    }

    private void step(Coordinate fromC, Coordinate toC){
        ImageView from = getChildAtRowCol(fromC.getX(),fromC.getY());
        ImageView to = getChildAtRowCol(toC.getX(),toC.getY());
        deleteHighlights();
        to.setImage(from.getImage());
        from.setImage(null);
        FigureArray.step(fromC, toC);
    }

    protected void deleteHighlights() {
        for (ImageView iv : highlighted) {
            if (iv.getImage() == null) {
                iv.setImage(null);
            } else if(iv.getImage().getUrl().replaceAll("^(.*[/])", "").equals("frm.png")){
                iv.setImage(null);
            } else {
                String unFramedEnemy = iv.getImage().getUrl().replaceAll("^(.*[/])", "").replaceAll("frm_", "");
                iv.setImage(new Image("/chess/piecespics/" + unFramedEnemy));
            }
        }
        highlighted = new ArrayList<>();
    }

    private void imageViewSetterForEnemy(int newX, int newY) {
        ImageView enemyImage = getChildAtRowCol(newX, newY);
        String framedEnemy = "frm_" + enemyImage.getImage().getUrl().replaceAll("^(.*[/])", "");
        enemyImage.setImage(new Image("/chess/piecespics/" + framedEnemy));
        highlighted.add(enemyImage);
    }

}
