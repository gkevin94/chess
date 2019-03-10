package chess;

import chess.enums.Figure;
import chess.pieces.FigureClass;
import javafx.scene.image.ImageView;

import java.util.Arrays;

public class FigureArray {


    private static FigureClass[][] figureArr = new FigureClass[8][8];

    public static FigureClass[][] getFigureArr() {
        return Arrays.stream(figureArr).map(FigureClass[]::clone).toArray(FigureClass[][]::new);
    }

    static void setFigureArr(FigureClass[][] figureArr) {
        FigureArray.figureArr = figureArr;
    }

    static void show(){
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(j + "-" + i +figureArr[j][i].getFigure() + "(" + figureArr[j][i].getSteps() + "), ");
            }
        }
        System.out.println("\n\n --------------------- ");
    }


//    private static Figure getFigureFromImageView(ImageView imageView){
//        String name = imageView.getImage().getUrl().replaceAll("^(.*[/])", "");
//        for (Figure figure: Figure.values()){
//            if (name.contains(figure.getName())){
//                return figure;
//            }
//        }
//        return Figure.EMPTY;
//    }

    public static FigureClass getFigureAt(int x, int y){
        return figureArr[x][y];
    }

    public static FigureClass getFigureAt(Coordinate c){
        return figureArr[c.getX()][c.getY()];
    }

    public static Coordinate getCoordinateFromFigure(String id){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (figureArr[i][j].getID().equals(id)){
                    return new Coordinate(i,j);
                }
            }
        }
        return new Coordinate(-1,-1);
    }

    public static void step(Coordinate from, Coordinate to){
        if(getFigureAt(to).getID().equals("empty")){
            FigureClass holder = figureArr[to.getX()][to.getY()];
            figureArr[to.getX()][to.getY()] = figureArr[from.getX()][from.getY()];
            figureArr[from.getX()][from.getY()] = holder;
            figureArr[to.getX()][to.getY()].addStep();
        } else {
            figureArr[to.getX()][to.getY()] = figureArr[from.getX()][from.getY()];
            figureArr[from.getX()][from.getY()] = new FigureClass(Figure.EMPTY, "empty");
            figureArr[to.getX()][to.getY()].addStep();
        }
    }
}
