package games.dice.goose;

import games.MoveResult;
import games.dice.MoveRules;

public enum GooseMoveResult implements MoveResult {
    WIN,
    REBOUND,
    GOOSE,
    BRIDGE,
    DEFAULT
}