package chess;

import chess.enums.Color;
import chess.enums.Figure;
import chess.pieces.FigureClass;
import chess.secondtr.Highligther;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Highligther implements Initializable {

    public GridPane gridPane;

    private ImageView clickedOn;
    private FigureClass selectedFigure;
    private boolean selecter = true;
    private int stepsOfTheGame;

    public void move(MouseEvent me){
        setChildren(gridPane.getChildren());
        if (stepsOfTheGame % 2 == 0 ){
            roundOfWhite(me);
        } else {
            roundOfBlack(me);
        }

    }

    private void roundOfWhite(MouseEvent me){
        String url = ((ImageView)me.getSource()).getImage().getUrl();

        if (url.contains("white") || (url.contains("frm") && selectedFigure.getColor() == Color.WHITE)){
            Coordinate coordinateClickedOn = getCoordinat((ImageView) me.getSource());
            FigureClass clickedOnFigure = FigureArray.getFigureAt(coordinateClickedOn);
            if (selecter){
                selectedFigure = FigureArray.getFigureAt(getCoordinat((ImageView) me.getSource()));
                selecter = false;
                highlightPossibleSteps(selectedFigure);
            } else {
                if (((ImageView)me.getSource()).getImage().getUrl().contains("frm")){
                    stepOver(FigureArray.getCoordinateFromFigure(selectedFigure.getID()), coordinateClickedOn);
                    selecter = true;
                    stepsOfTheGame++;
                } else {
                    deleteHighlights();
                    selectedFigure = clickedOnFigure;
                    selecter = false;
                    highlightPossibleSteps(selectedFigure);
                }
            }
            FigureArray.show();
        }
    }

    private void roundOfBlack(MouseEvent me){
        String url = ((ImageView)me.getSource()).getImage().getUrl();

        if (url.contains("black") || (url.contains("frm") && selectedFigure.getColor() == Color.BLACK)){
            Coordinate coordinateClickedOn = getCoordinat((ImageView) me.getSource());
            FigureClass clickedOnFigure = FigureArray.getFigureAt(coordinateClickedOn);
            if (selecter){
                selectedFigure = FigureArray.getFigureAt(getCoordinat((ImageView) me.getSource()));
                selecter = false;
                highlightPossibleSteps(selectedFigure);
            } else {
                if (((ImageView)me.getSource()).getImage().getUrl().contains("frm")){
                    stepOver(FigureArray.getCoordinateFromFigure(selectedFigure.getID()), coordinateClickedOn);
                    selecter = true;
                    stepsOfTheGame++;
                } else {
                    deleteHighlights();
                    selectedFigure = clickedOnFigure;
                    selecter = false;
                    highlightPossibleSteps(selectedFigure);
                }
            }
            FigureArray.show();
        }
    }


    private void figureArrayFiller(){
        FigureClass[][] figureArr = new FigureClass[8][8];
        for (Node node: gridPane.getChildren()){

            Image image = ((ImageView)node).getImage();
            int x = GridPane.getColumnIndex(node);
            int y = GridPane.getRowIndex(node);

            if (image == null){
                figureArr[x][y] = new FigureClass(Figure.EMPTY, "empty");
            } else {
                figureArr[x][y] = figureFinder(image.getUrl(),node.getId());
            }
        }
        FigureArray.setFigureArr(figureArr);
    }

    private FigureClass figureFinder(String url,String id){
        for (Figure figure: Figure.values()){
            if (url.contains(figure.getName())){
                return new FigureClass(figure, id);
            }
        }
        return new FigureClass(Figure.EMPTY, "empty");
    }

    private Coordinate getCoordinat(ImageView imageView){
        return new Coordinate(GridPane.getColumnIndex(imageView), GridPane.getRowIndex(imageView));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        figureArrayFiller();
        FigureArray.show();
    }



    //    public void move(MouseEvent mouseEvent) {
//        if (stepCounter == 0) { figureArrayFiller(); }
//        else {}
//        FigureArray.show();
//        setChildren(gridPane.getChildren());
//        if (selecter){
//            clickedOn = (ImageView) mouseEvent.getSource();
//            selecter = false;
//            highlightPossibleSteps(figureFinder(clickedOn),getCoordinat(clickedOn));
//            figureArrayFiller();
//        } else if (!selecter){
//            if (((ImageView)mouseEvent.getSource()).getImage().getUrl().contains("frm")){
//                stepOver(clickedOn, (ImageView)mouseEvent.getSource());
//                selecter = true;
//            } else {
//                deleteHighlights();
//                clickedOn = (ImageView) mouseEvent.getSource();
//                selecter = false;
//                highlightPossibleSteps(figureFinder(clickedOn),getCoordinat(clickedOn));
//            }
//            figureArrayFiller();
//        }
//        System.out.println("\n\n ------------------------------ \n");
//        FigureArray.show();
//    }


    //    private FigureClass figureFinder(ImageView imageView, String id){
//        String url = imageView.getImage().getUrl();
//        for (Figure figure: Figure.values()){
//            if (url.contains(figure.getName())){
//                return new FigureClass(figure, id);
//            }
//        }
//        return new FigureClass(Figure.EMPTY, "empty");
//    }



//    private Figure whoIAm(ImageView imageView){
//        String str = imageView.getImage().getUrl();
//        for (Figure f: Figure.values()){
//            String[] sArr = str.split("/");
//            if (sArr[sArr.length-1].contains(f.getName())){
//                return f;
//            }
//        }
//        throw new IllegalStateException("Figure not found.");
//    }
//
//    private Color whatIsMyColor(String str){
//        if (str.contains("black_")) return Color.BLACK;
//        else return Color.WHITE;
//    }





//    public static boolean[][] pane = new boolean[8][8];
//    private ImageView destination;
//
//    private boolean alreadyClickedOnce = false;
//    private ImageView firstClicked;
//    protected List<ImageView> highlighted = new ArrayList<>();
//
//    public void checkWhereCanImove(MouseEvent mouseEvent) {
//        if (!alreadyClickedOnce){
//            deleteHighlights();
//            System.out.println("1");
//            firstClicked = (ImageView) mouseEvent.getSource();
//            alreadyClickedOnce = true;
//        } else if (!((ImageView)mouseEvent.getSource()).getImage().getUrl().contains("frame")){
//            System.out.println("2");
//            deleteHighlights();
//            firstClicked = (ImageView) mouseEvent.getSource();
//        } else {
//            System.out.println("3");
//            ifNeededIWillDeleteThem((ImageView) mouseEvent.getSource());
//        }
//        destination = ((ImageView) mouseEvent.getSource());
//        paneFiller();
//        //System.out.println(destination.getImage().getUrl());
//
//        if (alreadyClickedOnce && !destination.getImage().getUrl().contains("frame")){
//            String imageName = destination.getImage().getUrl().replaceAll("^(.*[\\/])","");
//            System.out.println("2 / 1");
//            Coordinate coordinate = new Coordinate(GridPane.getColumnIndex(destination),GridPane.getRowIndex(destination));
//            ChessFigure chessFigure = new ChessFigure(whoIAm(destination.getImage().getUrl()),coordinate, whatIsMyColor(imageName));
//            getFreeSteps(chessFigure);
//        }
////        else {
////            System.out.println("2 / 2");
////            ifNeededIWillDeleteThem(destination);
////        }
//    }
//
//    private void ifNeededIWillDeleteThem(ImageView currentlyClicked){
//        if (highlighted.contains(currentlyClicked)){
//            System.out.println("delete1");
//            deleteHighlights();
//            currentlyClicked.setImage(firstClicked.getImage());
//            firstClicked.setImage(null);
//            alreadyClickedOnce = false;
//        } else {
//            System.out.println("delete2");
//            deleteHighlights();
//            firstClicked = currentlyClicked;
//            alreadyClickedOnce = true;
//        }
//    }
//
//    private Figure whoIAm(String str){
//        for (Figure f: Figure.values()){
//            String[] sArr = str.split("/");
//            if (sArr[sArr.length-1].contains(f.getName())){
//                return f;
//            }
//        }
//        throw new IllegalStateException("Figure not found.");
//    }
//
//    protected Color whatIsMyColor(String str){
//        if (str.contains("black_")) return Color.BLACK;
//        else return Color.WHITE;
//    }
//
//    private void paneFiller(){
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                pane[i][j] = isEmpty( Objects.requireNonNull(getChildAtRowCol(i, j)));
//            }
//        }
//    }
//
//    private void getFreeSteps(ChessFigure chessFigure){
//        MoveList[] possibleCoordinates;
//        if (chessFigure.getFigure() == Figure.PAWN){
//            possibleCoordinates = chessFigure.whereCanIStep();
//            highlighted = highlightPossibleSteps(chessFigure, possibleCoordinates);
//        }
//    }
//
//
//
//    protected boolean isEmpty(ImageView imageView){
//        Image image = imageView.getImage();
//        return image == null || image.isError();
//    }
//
//     void deleteHighlights(){
//        for (ImageView iv: highlighted){
//            iv.setImage(null);
//        }
//        highlighted = new ArrayList<>();
//        alreadyClickedOnce = false;
//    }
//
//
//    protected ImageView getChildAtRowCol(int row, int col){
//        for (Node child: gridPane.getChildren()){
//            if(GridPane.getColumnIndex(child) == col && GridPane.getRowIndex(child) == row){
//                return (ImageView) child;
//            }
//        }
//        return null;
//    }

}