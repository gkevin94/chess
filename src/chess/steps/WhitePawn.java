//package chess.steps;
//
//import chess.Controller;
//import chess.Coordinate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public interface WhitePawn {
//
//     final int MAX_X = 7;
//     final int MAX_Y = 7;
//     final int MIN_X = 0;
//     final int MIN_Y = 0;
//
//
//    default List<Coordinate> whitePawn(Coordinate coordinate){
//        int x = coordinate.getX();
//        int y = coordinate.getY();
//
//        List<Coordinate> coordinates = new ArrayList<>();
//        if (x > MIN_X && !Controller.pane[y-1][x-1]){
//            coordinates.add(new Coordinate(x-1, y-1));
//        }
//        if (x >= MIN_X && x < MAX_X && !Controller.pane[y-1][x+1]){
//            coordinates.add(new Coordinate(x+1, y-1));
//        }
//        if (y == 6){
//            coordinates.add(new Coordinate(x,y-2));
//        }
//
//        if (y-1 >= MIN_Y){
//            coordinates.add(new Coordinate(x,y-1));
//        }
//
//        return coordinates;
//    }
//}
