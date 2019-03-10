//package chess;
//
//import chess.enums.Color;
//import chess.enums.Figure;
//import chess.pieces.*;
//import javafx.collections.ObservableList;
//import javafx.scene.Node;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//
//public class ChessFigure {
//
//    private Figure figure;
//    private Coordinate currentlyAt;
//    private Color color;
//    private ObservableList<Node> children;
//
//    public ChessFigure(ImageView imageView, ObservableList<Node> children) {
//        this.children = children;
//        this.figure = whoIAm(imageView);
//        this.currentlyAt = whereAmI(imageView);
//        this.color = whatIsMyColor(imageView);
//    }
//
//    public Figure getFigure() {
//        return figure;
//    }
//
//    public Coordinate getCurrentlyAt() {
//        return currentlyAt;
//    }
//
//    public Color getColor() {
//        return color;
//    }
//
//    public Coordinate[] stepWithFigure(){
//        switch (figure.getName().replaceAll("^(.*[_]+)","")){
//            case "pawn":
//                if (figure == Figure.B_PAWN) return new BlackPawn(children).getCoordinatesWhereICanStep(currentlyAt);
//                else return new WhitePawn(children).getCoordinatesWhereICanStep(currentlyAt);
//            case "rook":
//                return new Rook(children).getCoordinatesWhereICanStep(currentlyAt);
//            case "bishop":
//                return new Bishop(children).getCoordinatesWhereICanStep(currentlyAt);
//            case "knight":
//                return new Knight(children).getCoordinatesWhereICanStep(currentlyAt);
//            case "king":
//                return new King(children).getCoordinatesWhereICanStep(currentlyAt);
//            case "queen":
//                return new Queen(children).getCoordinatesWhereICanStep(currentlyAt);
//                default:
//                        return new Coordinate[]{};
//        }
//    }
////
////    private Coordinate[] stepWithBlack() {
////        switch (figure){
////            case PAWN:
////                return new BlackPawn(children).getCoordinatesWhereICanStep(currentlyAt);
////            case ROOK:
////                return new Rook(children).getCoordinatesWhereICanStep(currentlyAt);
////            default:
////                return new Coordinate[]{};
////        }
////    }
////
////    private Coordinate[] stepWithWhite(){
////        switch (figure){
////            case PAWN:
////                return new WhitePawn(children).getCoordinatesWhereICanStep(currentlyAt);
////            case ROOK:
////                return new WhiteRook(children).getCoordinatesWhereICanStep(currentlyAt);
////                default:
////                return new Coordinate[]{};
////        }
////    }
//
//    private Coordinate whereAmI(ImageView imageView){
//        return new Coordinate(GridPane.getColumnIndex(imageView),GridPane.getRowIndex(imageView));
//    }
//
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
//    private Color whatIsMyColor(ImageView imageView){
//        String str = imageView.getImage().getUrl();
//        if (str.contains("black_")) return Color.BLACK;
//        else return Color.WHITE;
//    }
//
//
//}
