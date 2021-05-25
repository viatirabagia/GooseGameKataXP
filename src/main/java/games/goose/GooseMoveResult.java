package games.goose;

public enum GooseMoveResult implements MoveRules.MoveResult {
    WIN,
    REBOUND,
    GOOSE,
    BRIDGE,
    DEFAULT
}