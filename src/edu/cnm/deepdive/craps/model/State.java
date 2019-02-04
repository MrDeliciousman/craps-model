package edu.cnm.deepdive.craps.model;

/**
 * <code>State</code> implements a basic state machine for
 * the main play of a
 * game of Craps.
 * @author raymondherrera  &amp; Deep Dive Coding Java +
 * Android Cohort 6
 * @version 1.0
 */

public enum State {
  COME_OUT {
    @Override
    public State change(int roll, int pointValue) {
      switch (roll) {
        case 2:
        case 3:
        case 12:
          return LOSS;
        case 7:
        case 11:
          return WIN;
        default:
          return POINT;
      }
    }
  },
  POINT {
    @Override
    public State change(int roll, int pointValue) {
      if (roll == 7) {
        return LOSS;
      } if (roll == pointValue) {
        return WIN;
      }
      return POINT;
    }
  },
  WIN,
  LOSS;

  /**
   *
   * @param roll sum of dice in a current roll
   * @param pointValue establishes point value (ignored
   * @return
   */

  public State change(int roll, int pointValue) {
    return this;
  }

}
