//package chess;
//
//import chess.enums.Color;
//import chess.pieces.Piece;
//import javafx.collections.ObservableList;
//import javafx.scene.Node;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Highlighter {
//
//    public ObservableList<Node> children;
//
//    public Image image = new Image("/chess/piecespics/frm.png");
//
//    private List<ImageView> highlighted = new ArrayList<>();
//
//    public void setChildren(ObservableList<Node> children) {
//        this.children = children;
//    }
//
//    void highlightPossibleSteps(ChessFigure chessFigure) {
//        Coordinate[] coordinates = chessFigure.stepWithFigure();
//        for (Coordinate c : coordinates) {
//            imageSetter(c);
//        }
//    }
//
//    void stepOver(ImageView from, ImageView to) {
//        deleteHighlights();
//        if (!kingCastlingSetterifNeeded(from, to)) {
//            to.setImage(from.getImage());
//            from.setImage(null);
//        }
//    }
//
//    private void imageSetter(Coordinate c) {
//        ImageView imageView = getChildAtRowCol(c.getY(), c.getX());
//        if (isEmpty(imageView)) {
//            imageView.setImage(image);
//        } else {
//            imageViewSetterForEnemy(c.getX(),c.getY());
//        }
//        highlighted.add(imageView);
//    }
//
//    private void imageViewSetterForEnemy(int newX, int newY) {
//        ImageView enemyImage = getChildAtRowCol(newY, newX);
//        String framedEnemy = "frm_" + enemyImage.getImage().getUrl().replaceAll("^(.*[/])", "");
//        enemyImage.setImage(new Image("/chess/piecespics/" + framedEnemy));
//        highlighted.add(enemyImage);
//    }
//
//
//    private ImageView getChildAtRowCol(int row, int col) {
//        for (Node child : children) {
//            if (GridPane.getColumnIndex(child) == col && GridPane.getRowIndex(child) == row) {
//                return (ImageView) child;
//            }
//        }
//        return null;
//    }
//
//    public void deleteHighlights() {
//        for (ImageView iv : highlighted) {
//            if (isEmpty(iv)) {
//                iv.setImage(null);
//            } else {
//                String unFramedEnemy = iv.getImage().getUrl().replaceAll("^(.*[/])", "").replaceAll("frm_", "");
//                iv.setImage(new Image("/chess/piecespics/" + unFramedEnemy));
//            }
//        }
//        highlighted = new ArrayList<>();
//    }
//
//    private boolean isEmpty(ImageView imageView) {
//        Image image = imageView.getImage();
//        return image == null || image.isError() || imageView.getImage().getUrl().replaceAll("^(.*[/])", "").equals("frm.png");
//    }
//
//    private boolean kingCastlingSetterifNeeded(ImageView from, ImageView to){
//        //if (getChildAtRowCol(7,4) != from || getChildAtRowCol(0,4) != from) return false;
//        if (getNameOfImageView(from).equals("king.png")){
//            System.out.println("first in");
//            System.out.println((getNameOfImageView(getChildAtRowCol(7,7))).contains("root.png") && isBetweenKingAndRookEmpty(from, true));
//            if ((getNameOfImageView(getChildAtRowCol(7,7))).contains("root.png") && isBetweenKingAndRookEmpty(from, true)){
//                getChildAtRowCol(7,5).setImage(getChildAtRowCol(7,7).getImage());
//                getChildAtRowCol(7,7).setImage(null);
//                return true;
//            }
//            if ((getNameOfImageView(getChildAtRowCol(7,0))).contains("root.png") && isBetweenKingAndRookEmpty(from, false)){
//                getChildAtRowCol(7,2).setImage(getChildAtRowCol(7,0).getImage());
//                getChildAtRowCol(7,2).setImage(null);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isBetweenKingAndRookEmpty(ImageView imageView, boolean ASC){
//        if (ASC) {
//            for (int i = (int) imageView.getX() + 1; i < 7; i++) {
//                if (!isEmpty(getChildAtRowCol(i, (int) imageView.getY()))) {
//                    return false;
//                }
//            }
//            return true;
//        } else {
//            for (int i = (int) imageView.getX()-1; i > 0; i--) {
//                if (!isEmpty(getChildAtRowCol(i,(int) imageView.getY()))){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
//
//    private String getNameOfImageView(ImageView imageView){
//        return imageView.getImage().getUrl().replaceAll("^(.*[/][a-z]+)", "");
//    }
//}
//
////
////     private Coordinate[] whereCanIMoveBlack(ChessFigure chessFigure){
////        switch (chessFigure.getFigure()){
////            case PAWN:
////                return new BlackPawn().getCoordinatesWhereICanStep(chessFigure.getCurrentlyAt());
////                default:
////                    return new Coordinate[]{};
////        }
////     }
////
////     private Coordinate[] whereCanIMoveWhite(ChessFigure chessFigure){
////        switch (chessFigure.getFigure()){
////            case PAWN:
////                return new WhitePawn().getCoordinatesWhereICanStep(chessFigure.getCurrentlyAt());
////                default:
////                    return new Coordinate[]{};
////        }
//
////     }
//
////     private void imageSetter(ChessFigure chessFigure, Coordinate m){
////        try {
////            int newX = chessFigure.getCurrentlyAt().getX() + m.getX();
////            int newY = chessFigure.getCurrentlyAt().getY() + m.getY();
////
////            if (m.getX() == 0 && isEmpty(getChildAtRowCol(newY,newX))){
////                ImageView imageView = getChildAtRowCol(newY, newX);
////                imageViewSetterForEmpty(imageView);
////            } else if (checkIfItsEnemy(newX,newY, chessFigure.getCurrentlyAt().getX(), chessFigure.getCurrentlyAt().getY())){
////                // enemy
////                imageViewSetterForEnemy(newX, newY);
////            }
////        } catch (RuntimeException re){
////        }
//
////    }
////    private boolean checkIfItsEnemy(int oldX, int oldY, int newX, int newY){
////         return whatIsMyColor(getChildAtRowCol(newY,newX).getImage().getUrl()) != whatIsMyColor(getChildAtRowCol(oldY,oldX).getImage().getUrl());
//
////    }
////    private Color whatIsMyColor(String str){
////        if (str.contains("black_")) return Color.BLACK;
////        else return Color.WHITE;
////    }
////
////    private void imageViewSetterForEmpty(ImageView imageView){
////         imageView.setImage(image);
////         highlighted.add(imageView);
////    }
////
////    private void imageViewSetterForEnemy(int newX, int newY){
////        ImageView enemyImage = getChildAtRowCol(newY, newX);
////        String framedEnemy = "frm_" + enemyImage.getImage().getUrl().replaceAll("^(.*[/])","");
////        enemyImage.setImage(new Image("/chess/piecespics/" + framedEnemy));
////        highlighted.add(enemyImage);
//
////    }
//
//
