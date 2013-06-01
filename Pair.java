/** Pair.java
 *  Simple object to hold a pair of doubles to store in queue. Works as an
 *  immutable object with public fields.
 */

public class Pair
{
    public final double x, y;

    public Pair(double a, double b)
    {
        x = a;
        y = b;
    }

    public String toString()
    {
        return String.format("(%f, %f)", x, y);
    }
}
