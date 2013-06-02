/** Data.java
 *  Simple object to hold the necessary pendulum data to store in the queue.
 *  Implemented as an immutable object with public fields.
 */

public class Data
{
    public final double x1, y1, x2, y2, KE, PE;

    public Data(double xp1, double yp1, double xp2, double yp2,
        double k, double p)
    {
        x1 = xp1;
        y1 = yp1;
        x2 = xp2;
        y2 = yp2;
        KE = k;
        PE = p;
    }
}
