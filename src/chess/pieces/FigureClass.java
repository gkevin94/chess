package chess.pieces;

import chess.Coordinate;
import chess.FigureArray;
import chess.enums.Color;
import chess.enums.Figure;

public class FigureClass {

    private final String ID;
    private Figure figure;
    private int steps = 0;
    private Color color;
    private String imageURL;

    private Figure oldFigure;
    private String frm_imageURL;

    public FigureClass(Figure figure, String id) {
        this.figure = figure;
        this.ID = id;
        setColor(figure);
        imageSetter();
    }

    public String getImage() {
        return imageURL;
    }

    public String getFrm_image() {
        return frm_imageURL;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getID() {
        return ID;
    }

    public Color getColor() {
        return color;
    }

    public void setFigure(Figure figure) {
        oldFigure = this.figure;
        this.figure = figure;
    }

    public void changeBack(){
        figure = oldFigure;
        oldFigure = null;
    }

    public int getSteps() {
        return steps;
    }

    public void addStep(){
        this.steps = steps + 1;
    }

    private void setColor(Figure figure){
        if (figure.getName().contains("white")){
            this.color = Color.WHITE;
        } else if (figure.getName().contains("black")){
            this.color = Color.BLACK;
        } else {
            this.color = Color.EMPTY;
        }
    }

    private void imageSetter(){
        String name = figure.getName();
        this.imageURL = "/chess/piecespics/" + name + ".png";
        this.frm_imageURL = "/chess/piecespics/frm_" + name + ".png";
    }

    public Coordinate[] stepWithFigure(){
        Coordinate currentlyAt = FigureArray.getCoordinateFromFigure(ID);
        switch (figure.getName().replaceAll("^(.*[_]+)","")){
            case "pawn":
                if (figure == Figure.B_PAWN) return new BlackPawn().getCoordinatesWhereICanStep(currentlyAt);
                else return new WhitePawn().getCoordinatesWhereICanStep(currentlyAt);
            case "rook":
                return new Rook().getCoordinatesWhereICanStep(currentlyAt);
            case "bishop":
                return new Bishop().getCoordinatesWhereICanStep(currentlyAt);
            case "knight":
                return new Knight().getCoordinatesWhereICanStep(currentlyAt);
            case "king":
                return new King().getCoordinatesWhereICanStep(currentlyAt);
            case "queen":
                return new Queen().getCoordinatesWhereICanStep(currentlyAt);
            default:
                return new Coordinate[]{};
        }
    }
}
