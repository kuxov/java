package ru.spbstu.main.shapes;
import java.lang.Math;

public class Dot implements Point
{
    public Dot(float x, float y)
    {
        x_ = x;
        y_ = y;
    }

    @Override
    public float getX()
    {
        return x_;
    }
    @Override
    public float getY()
    {
        return y_;
    }

    private float x_;
    private float y_;
}
