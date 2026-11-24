package frc.lib.util;

public class PIDGains {
  // These are public properties which allow them to be accessed directly without need for get/set
  // methods.
  // final means that they are immutable after object creation, attempting to change them will cause
  // a compile error.
  public final double kp;
  public final double ki;
  public final double kd;
  public final double kf;

  /**
   * PIDGains constructor is protected so that it can only be constructed through the use of the
   * Builder Details of PID control can be found in the WPI documentation
   * https://docs.wpilib.org/en/stable/docs/software/advanced-controls/introduction/introduction-to-pid.html#introduction-to-pid
   *
   * @param builder
   */
  protected PIDGains(Builder builder) {
    this.kp = builder.kp;
    this.ki = builder.ki;
    this.kd = builder.kd;
    this.kf = builder.kf;
  }

  public static class Builder {
    public double kp = 0.0;
    public double ki = 0.0;
    public double kd = 0.0;
    public double kf = 0.0;

    public Builder kp(double kp) {
      if (kp < 0.0) throw new IllegalArgumentException();
      this.kp = kp;
      return this;
    }

    /**
     * The integral gain.
     *
     * @param ki The integral gain. Must be greater than or equal to 0.0.
     * @return this FeedforwardGains Builder
     */
    public Builder ki(double ki) {
      if (ki < 0.0) throw new IllegalArgumentException();
      this.ki = ki;
      return this;
    }

    public Builder kd(double kd) {
      if (kd < 0.0) throw new IllegalArgumentException();
      this.kd = kd;
      return this;
    }

    public Builder kf(double kf) {
      if (kf < 0.0) throw new IllegalArgumentException();
      this.kf = kf;
      return this;
    }

    public PIDGains build() {
      return new PIDGains(this);
    }
  }
}