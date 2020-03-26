package ru.spbstu.main.shapes;

public class Circle implements Ellipse
{
    public Circle(float radius, Dot center)
    {
        if (radius <= 0)
        {
            throw new NumberFormatException("Radius must be greater than zero");
        }
        radius_ = radius;
        center_ = center;
    }
    
    @Override
    public float getArea()
    {
        return ((float)Math.PI * radius_ * radius_);
    }

    @Override
    public int getRotation()
    {
        return 0;
    }

    public float getLength()
    {
        return (float) (2 * Math.PI * radius_);
    }

    @Override
    public String print()
    {
        return "Circle (" + center_.getX() + ", " + center_.getY() + "), radius = " + radius_ + ", area =  " + getArea();
    }

    private float radius_;
    private Dot center_;
}
