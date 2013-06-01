/** Pendulum.java
 *  This program simulates a double pendulum using a Runge-Kutta approximation.
 *
 *  This file serves two purposes:
 *  1. Contains the main method and initializes the simulation
 *  2. Serves as a Pendulum object
 */

//  Laziness to avoid writing "Math."
import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Pendulum implements Runnable
{
    public static void main(String[] args)
    {
        Pendulum p = new Pendulum(1, 0.9, 1, 0.9, 179.999, 179.999, 0, 0, 0.001);
        for (int i = 0; i < 10; i++)
        {
            p.step();
            System.out.println(p.get());
        }
    }

    public void run()
    {
    }

    private static final double g = 9.80665;
    private double L1, L2, m1, m2, t1, t2, w1, w2, h;

    public Pendulum(
        double length1, double length2,
        double mass1, double mass2,
        double theta1, double theta2,
        double omega1, double omega2,
        double stepsize)
    {
        L1 = length1;
        L2 = length2;
        m1 = mass1;
        m2 = mass2;
        t1 = theta1;
        t2 = theta2;
        w1 = omega1;
        w2 = omega2;
        h = stepsize;
    }

    public Pair get()
    {
        return new Pair(0, 0);
    }

    public void step()
    {
        
    }

    private double f1(double t1, double t2, double w1, double w2)
    {
        return (g*(m2*sin(t2)*cos(t1-t2)-(m1+m2)*sin(t1))-m2*(L2*w1*w1*
            cos(t1-t2))*sin(t1-t2))/(L1*(m1+m2*sin(t1-t2)*sin(t1-t2)));
    }

    private double f2(double t1, double t2, double w1, double w2)
    {
        return 0;
    }
}
