package chess.pieces;

import chess.Coordinate;

import java.util.Arrays;
import java.util.stream.Stream;

public class Queen extends Piece {

    @Override
    public Coordinate[] getCoordinatesWhereICanStep(Coordinate coordinate) {
        Coordinate[] coordinatesFromRook = new Rook().getCoordinatesWhereICanStep(coordinate);
        Coordinate[] coordinatesFromBishop = new Bishop().getCoordinatesWhereICanStep(coordinate);
        return Stream.concat(Arrays.stream(coordinatesFromBishop),Arrays.stream(coordinatesFromRook))
                .toArray(Coordinate[]::new);
    }
}
