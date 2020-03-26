package ru.spbstu.main.shapes;

public class Rectangle implements Shape
{
    public Rectangle(float a, float b, int angle)
    {
        if((a <= 0)||(b <= 0))
        {
            throw new IllegalArgumentException("Sides length must be greater than zero");
        }
        if((angle < 0) || (angle > 360))
        {
            throw new IllegalArgumentException("Angle  must be in [0, 360] range");
        }
        a_ = a;
        b_ = b;
        angle_ = angle;
    }

    @Override
    public float getArea()
    {
      return (a_ * b_);
    }

    @Override
    public int getRotation()
    {
      return angle_;
    }
    @Override

    public String print()
    {
        return "Rectangle a = " + a_ + ", b = " + b_ + ", area =  " + getArea();
    }

    private float a_;
    private float b_;
    private int angle_;
}
