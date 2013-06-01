/** Pendulum.java
 *  This program simulates a double pendulum using a Runge-Kutta approximation.
 */

public class Pendulum
{
    public static void main(String[] args)
    {
        Pendulum p = new Pendulum(1, 0.9, 1, 0.9, 179.999, 179.999, 0, 0);
        for (int i = 0; i < 10; i++)
        {
            p.step(0.001);
            System.out.printf("(%f, %f)%n", p.getX(), p.getY());
        }
    }

    public Pendulum(
        double length1, double length2,
        double mass1, double mass2,
        double theta1, double theta2,
        double omega1, double omega2)
    {
    }

    public void step(double delta)
    {
    }

    public double getX()
    {
        return 0;
    }

    public double getY()
    {
        return 0;
    }
}
