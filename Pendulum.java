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

import java.awt.EventQueue;

public class Pendulum
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                PendulumConsumer pc = new PendulumConsumer();
            }
        });
    }

    private static final double g = 9.80665;
    private double L1, L2, m1, m2, t1, t2, w1, w2, h;
    private double time;

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
        time = 0;
    }

    public Data get()
    {
        return new Data(getX1(), getY1(), getX2(), getY2(), getKE(), getPE());
    }

    public void step()
    {
        double t1a, t2a, w1a, w2a,
               t1b, t2b, w1b, w2b,
               t1c, t2c, w1c, w2c,
               t1d, t2d, w1d, w2d;

        t1a = h*t1;
        t2a = h*t2;
        w1a = h*f1(t1, t2, w1, w2);
        w2a = h*f2(t1, t2, w1, w2);

        t1b = h*(t1+t1a/2);
        t2b = h*(t2+t2a/2);
        w1b = h*f1(t1+t1a/2, t2+t2a/2, w1+w1a/2, w2+w2a/2);
        w2b = h*f2(t1+t1a/2, t2+t2a/2, w1+w1a/2, w2+w2a/2);

        t1c = h*(t1+t1b/2);
        t2c = h*(t2+t2b/2);
        w1c = h*f1(t1+t1b/2, t2+t2b/2, w1+w1b/2, w2+w2b/2);
        w2c = h*f2(t1+t1b/2, t2+t2b/2, w1+w1b/2, w2+w2b/2);

        t1d = h*(t1+t1c);
        t2d = h*(t2+t2c);
        w1d = h*f1(t1+t1c, t2+t2c, w1+w1c, w2+w2c);
        w2d = h*f2(t1+t1c, t2+t2c, w1+w1c, w2+w2c);

        time += h;
        t1 += (t1a+2*t1b+2*t1c+t1d)/6;
        t2 += (t2a+2*t2b+2*t2c+t2d)/6;
        w1 += (w1a+2*w1b+2*w1c+w1d)/6;
        w2 += (w2a+2*w2b+2*w2c+w2d)/6;
    }

    private double getX1()
    {
        return L1*sin(t1);
    }

    private double getY1()
    {
        return -L1*cos(t1);
    }

    private double getX2()
    {
        return getX1()+L2*sin(t2);
    }

    private double getY2()
    {
        return getY1()-L2*cos(t2);
    }

    private double getKE()
    {
        return ((m1+m2)*L1*L1*w1*w1*w1*w1+m2*L2*L2*w2*w2*w2*w2+m2*L1*L2*
            w1*w2*cos(t1-t2))/2;
    }

    private double getPE()
    {
        return -g*((m1+m2)*L1*cos(t1)+m2*L2*cos(t2));
    }

    private double f1(double t1, double t2, double w1, double w2)
    {
        return (g*(m2*sin(t2)*cos(t1-t2)-(m1+m2)*sin(t1))-m2*(L2*w1*w1*
            cos(t1-t2))*sin(t1-t2))/(L1*(m1+m2*sin(t1-t2)*sin(t1-t2)));
    }

    private double f2(double t1, double t2, double w1, double w2)
    {
        return (m2*L2*w2*w2*cos(t1-t2)+(m1+m2)*(L1*w1*w1+g*cos(t1)))*sin(t1-t2)/
            (L2*(m1+m2*sin(t1-t2)*sin(t1-t2)));
    }
}
